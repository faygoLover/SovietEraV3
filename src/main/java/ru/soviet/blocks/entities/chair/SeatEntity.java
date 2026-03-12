package ru.soviet.blocks.entities.chair;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.network.NetworkHooks;
import ru.soviet.reg.RegEntities;

public class SeatEntity extends Entity {
    private static final EntityDataAccessor<BlockPos> SEAT_POS = SynchedEntityData.defineId(SeatEntity.class, EntityDataSerializers.BLOCK_POS);
    private double seatHeight;
    private double seatDepth;
    private Direction facing; // не синхронизируется, но сохраняется в NBT

    public SeatEntity(EntityType<?> entityType, Level level) {
        super(entityType, level);
        this.noPhysics = true;
        this.setNoGravity(true);
    }

    public SeatEntity(Level level, BlockPos pos, double seatHeight, double seatDepth, Direction facing) {
        this(RegEntities.SEAT.get(), level);
        this.seatHeight = seatHeight;
        this.seatDepth = seatDepth;
        this.facing = facing;

        // Вычисляем позицию: центр блока + смещение по направлению взгляда
        double x = pos.getX() + 0.5 + facing.getStepX() * seatDepth;
        double z = pos.getZ() + 0.5 + facing.getStepZ() * seatDepth;
        double y = pos.getY() + seatHeight;
        this.setPos(x, y, z);
        this.entityData.set(SEAT_POS, pos);
    }

    @Override
    protected void defineSynchedData() {
        this.entityData.define(SEAT_POS, BlockPos.ZERO);
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag tag) {
        if (tag.contains("SeatPos")) {
            int[] pos = tag.getIntArray("SeatPos");
            if (pos.length == 3) {
                this.entityData.set(SEAT_POS, new BlockPos(pos[0], pos[1], pos[2]));
            }
        }
        if (tag.contains("SeatHeight")) {
            this.seatHeight = tag.getDouble("SeatHeight");
        }
        if (tag.contains("SeatDepth")) {
            this.seatDepth = tag.getDouble("SeatDepth");
        }
        if (tag.contains("Facing")) {
            this.facing = Direction.from3DDataValue(tag.getInt("Facing"));
        }
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag tag) {
        BlockPos pos = this.entityData.get(SEAT_POS);
        tag.putIntArray("SeatPos", new int[]{pos.getX(), pos.getY(), pos.getZ()});
        tag.putDouble("SeatHeight", this.seatHeight);
        tag.putDouble("SeatDepth", this.seatDepth);
        if (facing != null) {
            tag.putInt("Facing", facing.get3DDataValue());
        }
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.level().isClientSide) {
            // Удаляем, если нет пассажиров
            if (this.getPassengers().isEmpty()) {
                this.discard();
                return;
            }

            // Удаляем, если блок под нами больше не является стулом
            BlockPos pos = this.entityData.get(SEAT_POS);
            BlockState state = this.level().getBlockState(pos);
            if (!(state.getBlock() instanceof ChairBlock)) {
                this.discard();
            }
        }
    }

    @Override
    protected boolean canRide(Entity entity) {
        return true;
    }

    @Override
    public double getPassengersRidingOffset() {
        return 0.0; // пассажир сидит на уровне сущности
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    public boolean isPickable() {
        return false;
    }
}