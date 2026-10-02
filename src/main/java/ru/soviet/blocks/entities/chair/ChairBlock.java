package ru.soviet.blocks.entities.chair;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.VoxelShape;
import ru.soviet.blocks.baseblock.Directional4MBlock;

import java.util.Optional;

public class ChairBlock extends Directional4MBlock {
    private final double seatHeight;
    private final double seatDepth;

    public ChairBlock(Properties properties, String hoverTextKey, VoxelShape shape, double seatHeight, double seatDepth) {
        super(properties, hoverTextKey, shape);
        this.seatHeight = seatHeight;
        this.seatDepth = seatDepth;
    }

    public ChairBlock(Properties properties, VoxelShape shape, double seatHeight, double seatDepth) {
        this(properties, null, shape, seatHeight, seatDepth);
    }

    public ChairBlock(Properties properties, double seatHeight, double seatDepth) {
        this(properties, null, null, seatHeight, seatDepth);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!level.isClientSide) {
            // Если игрок уже сидит — не садим повторно
            if (player.isPassenger()) {
                return InteractionResult.PASS;
            }

            // Проверяем, есть ли уже сущность-сиденье в этой позиции
            Optional<SeatEntity> existingSeat = level.getEntitiesOfClass(SeatEntity.class, new AABB(pos),
                    e -> e.blockPosition().equals(pos) && e.isAlive()).stream().findFirst();

            SeatEntity seat;
            if (existingSeat.isPresent()) {
                seat = existingSeat.get();
                // Если место занято другим игроком — ничего не делаем
                if (!seat.getPassengers().isEmpty()) {
                    return InteractionResult.PASS;
                }
            } else {
                // Создаём новое сиденье с учётом высоты, глубины и направления блока
                seat = new SeatEntity(level, pos, seatHeight, seatDepth, state.getValue(FACING));
                level.addFreshEntity(seat);
            }

            // Поворачиваем игрока лицом в сторону, куда смотрит стул
            Direction facing = state.getValue(FACING).getOpposite();
            float yaw = switch (facing) {
                case SOUTH -> 0.0F;
                case WEST -> 90.0F;
                case NORTH -> 180.0F;
                case EAST -> 270.0F;
                default -> player.getYRot();
            };

            // Сажаем игрока
            player.startRiding(seat);

            // Устанавливаем начальный поворот для ограничений
            seat.setRiderStartYaw(yaw);

            // Принудительно устанавливаем вращение и синхронизируем с клиентом
            if (player instanceof ServerPlayer serverPlayer) {
                serverPlayer.connection.teleport(player.getX(), player.getY(), player.getZ(), yaw, 0.0F);
            }

            return InteractionResult.CONSUME;
        }
        return InteractionResult.SUCCESS;
    }

    // При разрушении блока удаляем связанную сущность
    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!level.isClientSide && state.getBlock() != newState.getBlock()) {
            level.getEntitiesOfClass(SeatEntity.class, new AABB(pos), e -> e.blockPosition().equals(pos))
                    .forEach(SeatEntity::discard);
        }
        super.onRemove(state, level, pos, newState, isMoving);
    }
}