package ru.soviet.blocks.decorative.innerdeco.devices;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import ru.soviet.blocks.baseblock.Directional4H2x2VMBlock;
import ru.soviet.reg.RegItems;
import ru.soviet.reg.RegSounds;
import net.minecraft.server.level.ServerPlayer;

public class FluoLamp2 extends Directional4H2x2VMBlock {
    public static final IntegerProperty LAMPS = IntegerProperty.create("lamps",0,2);
    public static final BooleanProperty TOGGLED = BooleanProperty.create("toggled");

    public FluoLamp2(Properties properties, VoxelShape shape) {
        super(properties.lightLevel(state -> {
            int lamps = state.getValue(LAMPS);
            boolean toggled = state.getValue(TOGGLED);
            return toggled ? lamps*7+1 : 0;
        }), "info.fluolamp2", shape);

        this.registerDefaultState(this.stateDefinition.any()
                .setValue(LAMPS, 0)
                .setValue(TOGGLED, false)
        );
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(LAMPS,TOGGLED);
    }

    @Override
    public @NotNull InteractionResult use(@NotNull BlockState state, Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hit) {
        var stack = player.getItemInHand(hand);
        var item = stack.getItem();
        int lamps = state.getValue(LAMPS);
        boolean toggled = state.getValue(TOGGLED);
        boolean actionPullerOpen = (lamps != 0) && item == RegItems.PULLER.get();
        boolean actionAddLamp = (lamps != 2) && item == RegItems.FLUOLAMP.get();
        boolean specialAction = actionPullerOpen || actionAddLamp;

        if (level.isClientSide) {
            return (specialAction || lamps != 0) ? InteractionResult.SUCCESS : InteractionResult.PASS;
        }

        if (specialAction) {
            if (actionPullerOpen) {
                // Демонтировать лампу
                int newLamps = lamps == 2 ? 1 : 0;
                boolean newToggled = newLamps != 0 && toggled;
                level.setBlock(pos, state.setValue(LAMPS, newLamps).setValue(TOGGLED, newToggled), 3);
                if (!player.isCreative()) {
                    Block.popResource(level, pos, new ItemStack(RegItems.FLUOLAMP.get()));
                    stack.hurt(1, level.random, (ServerPlayer) player);
                }
                level.playSound(null, pos, RegSounds.DEMONT.get(), SoundSource.BLOCKS, 0.5F, 1.0F);
            } else {
                // Установить лампу
                int newLamps = lamps == 0 ? 1 : 2;
                level.setBlock(pos, state.setValue(LAMPS, newLamps), 3);
                level.playSound(null, pos, RegSounds.SNAP.get(), SoundSource.BLOCKS, 0.2F, 1.0F);
                if (!player.isCreative()) {
                    stack.shrink(1);
                }
            }
            level.updateNeighborsAt(pos, this);
            return InteractionResult.CONSUME;
        } else {
            // Включение/выключение
            if (lamps != 0) {
                boolean newToggled = !toggled;
                level.setBlock(pos, state.setValue(TOGGLED, newToggled), 3);
                if (newToggled) {
                    level.playSound(null, pos, RegSounds.SNAP.get(), SoundSource.BLOCKS, 0.1F, 1.0F);
                    level.playSound(null, pos, RegSounds.FLUO_LAMP.get(), SoundSource.BLOCKS, 0.5F, 1.0F);
                } else {
                    level.playSound(null, pos, RegSounds.SNAP.get(), SoundSource.BLOCKS, 0.2F, 0.8F);
                }
                level.updateNeighborsAt(pos, this);
                return InteractionResult.CONSUME;
            }
            return InteractionResult.PASS;
        }
    }

    @Override
    public void onRemove(@NotNull BlockState state, Level level, @NotNull BlockPos pos, @NotNull BlockState newState, boolean isMoving) {
        if (!level.isClientSide && !state.is(newState.getBlock())) {
            int lamps = state.getValue(LAMPS);

            for (int i = 0; i < lamps; i++) {
                Block.popResource(level, pos, new ItemStack(RegItems.FLUOLAMP.get()));
            }
        }
        super.onRemove(state, level, pos, newState, isMoving);
    }
}
