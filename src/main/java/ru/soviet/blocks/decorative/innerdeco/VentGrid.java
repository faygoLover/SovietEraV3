package ru.soviet.blocks.decorative.innerdeco;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import ru.soviet.blocks.baseblock.Directional4H4x2VMBlock;
import ru.soviet.reg.RegSounds;
import ru.soviet.utils.ExtendedShapeRotator4H4x2V;

public class VentGrid extends Directional4H4x2VMBlock {
    public static final BooleanProperty TOGGLED = BooleanProperty.create("toggled");
    private final VoxelShape shapeOff;
    private final VoxelShape shapeOn;

    public VentGrid(Properties properties, VoxelShape shapeOff, VoxelShape shapeOn) {
        super(properties, "info.toggleable", null);
        this.shapeOff = shapeOff;
        this.shapeOn = shapeOn;
        this.registerDefaultState(this.defaultBlockState().setValue(TOGGLED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(TOGGLED);
    }

    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter world, @NotNull net.minecraft.core.BlockPos pos, @NotNull CollisionContext context) {
        VoxelShape baseShape = state.getValue(TOGGLED) ? shapeOff : shapeOn;
        return ExtendedShapeRotator4H4x2V.rotateShape(baseShape, state.getValue(FACING));
    }

    @Override
    public @NotNull InteractionResult use(@NotNull BlockState state, Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hit) {
        if (!level.isClientSide) {
            level.setBlock(pos, state.setValue(TOGGLED, !state.getValue(TOGGLED)), 3);

            float pitch = !state.getValue(TOGGLED) ? 1.0F : 0.8F;
            level.playSound(null, pos, RegSounds.RELAY.get(), SoundSource.BLOCKS, 0.3F, pitch);

            level.updateNeighborsAt(pos, this);
        }
        return InteractionResult.sidedSuccess(level.isClientSide);
    }
}
