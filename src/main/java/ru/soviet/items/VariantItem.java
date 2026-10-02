package ru.soviet.items;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import org.jetbrains.annotations.NotNull;

/**
 * Вариатор: ПКМ переключает вариант блока — свойство damaged (свежая/старая краска у ступеней и плит)
 * или variant (газовые плиты, информационные табло).
 */
public class VariantItem extends BaseItem {
    private static final String[] VARIANT_PROPERTIES = {"damaged", "variant"};

    public VariantItem(Properties properties, String hoverTextKey) {
        super(properties.stacksTo(1), hoverTextKey);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = level.getBlockState(pos);

        for (String name : VARIANT_PROPERTIES) {
            Property<?> property = state.getBlock().getStateDefinition().getProperty(name);
            if (property == null) continue;
            if (!level.isClientSide) {
                level.setBlock(pos, state.cycle(property), 3);
                level.playSound(null, pos, SoundEvents.ITEM_FRAME_ROTATE_ITEM, SoundSource.BLOCKS, 0.6F, 1.0F);
            }
            return InteractionResult.sidedSuccess(level.isClientSide);
        }
        return InteractionResult.PASS;
    }
}
