package ru.soviet.blocks.decorative.innerdeco;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

import ru.soviet.blocks.baseblock.WallAttachedBlock;

public class Ladder extends WallAttachedBlock {
    public Ladder(Properties properties, String hoverTextKey, VoxelShape shape) {
        super(properties, hoverTextKey, shape);
    }

    public Ladder(Properties properties, String hoverTextKey) {
        this(properties, hoverTextKey, null);
    }

    public Ladder(Properties properties, VoxelShape shape) {
        this(properties, null, shape);
    }

    public Ladder(Properties properties) {
        this(properties, null, null);
    }

    @Override
    public boolean isLadder(BlockState state, LevelReader level, BlockPos pos, LivingEntity entity) {
        return true;
    }

}
