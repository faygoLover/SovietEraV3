package ru.soviet.blocks.entities.devices;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import ru.soviet.client.ClientPcSounds;
import ru.soviet.reg.RegBlockEntities;

public class PcBlockEntity extends BlockEntity {

    public PcBlockEntity(BlockPos pos, BlockState state) {
        super(RegBlockEntities.PC.get(), pos, state);
    }

    @Override
    public void setRemoved() {
        if (level != null && level.isClientSide) {
            ClientPcSounds.stop(worldPosition);
        }
        super.setRemoved();
    }
}
