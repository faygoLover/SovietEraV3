package ru.soviet.blocks.paint;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.soviet.blocks.baseblock.ModelBlock;
import ru.soviet.reg.RegItems;

/**
 * Ведро для краски. Ставится с водой; краситель в руке превращает воду в краску,
 * кисть забирает краску (ведро пустеет), пустое ведро заново наполняется ведром воды.
 */
public class DyeBucketBlock extends ModelBlock {
    public static final EnumProperty<BucketContent> COLOR = EnumProperty.create("color", BucketContent.class);

    private static final VoxelShape SHAPE = Shapes.or(
            Block.box(4, 3, 4, 12, 10, 12),
            Block.box(5, 3, 3, 11, 10, 13),
            Block.box(3, 3, 5, 13, 10, 11),
            Block.box(5, 0, 4, 11, 3, 12),
            Block.box(4, 0, 5, 12, 3, 11)
    );

    public DyeBucketBlock(Properties properties) {
        super(properties, "info.dye_bucket", SHAPE);
        this.registerDefaultState(this.stateDefinition.any().setValue(COLOR, BucketContent.WATER));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(COLOR);
    }

    @Nullable
    private static BucketContent contentFor(ItemStack stack) {
        if (stack.is(Items.RED_DYE)) return BucketContent.RED;
        if (stack.is(Items.ORANGE_DYE)) return BucketContent.ORANGE;
        if (stack.is(Items.YELLOW_DYE)) return BucketContent.YELLOW;
        if (stack.is(Items.GREEN_DYE)) return BucketContent.GREEN;
        if (stack.is(Items.BLUE_DYE)) return BucketContent.BLUE;
        if (stack.is(Items.WHITE_DYE)) return BucketContent.WHITE;
        if (stack.is(RegItems.BEIGE_DYE.get())) return BucketContent.BEIGE;
        if (stack.is(RegItems.BEIGE2_DYE.get())) return BucketContent.BEIGE2;
        // бетонный раствор для шпателя
        if (stack.is(Items.GRAY_DYE) || stack.is(RegItems.CONCRETE_SCRAP.get())) return BucketContent.FILLER;
        return null;
    }

    @Override
    public @NotNull InteractionResult use(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hit) {
        ItemStack stack = player.getItemInHand(hand);
        BucketContent content = state.getValue(COLOR);

        if (content == BucketContent.EMPTY && stack.is(Items.WATER_BUCKET)) {
            if (!level.isClientSide) {
                level.setBlock(pos, state.setValue(COLOR, BucketContent.WATER), 3);
                level.playSound(null, pos, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                if (!player.getAbilities().instabuild) {
                    player.setItemInHand(hand, new ItemStack(Items.BUCKET));
                }
            }
            return InteractionResult.sidedSuccess(level.isClientSide);
        }

        if (content == BucketContent.WATER) {
            BucketContent mixed = contentFor(stack);
            if (mixed != null) {
                if (!level.isClientSide) {
                    level.setBlock(pos, state.setValue(COLOR, mixed), 3);
                    level.playSound(null, pos, SoundEvents.DYE_USE, SoundSource.BLOCKS, 1.0F, 1.0F);
                    if (!player.getAbilities().instabuild) {
                        stack.shrink(1);
                    }
                }
                return InteractionResult.sidedSuccess(level.isClientSide);
            }
        }

        // Кисть и шпатель обрабатывают клик сами (Item.useOn)
        return InteractionResult.PASS;
    }
}
