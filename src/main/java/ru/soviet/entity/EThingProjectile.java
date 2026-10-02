package ru.soviet.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import ru.soviet.reg.RegEntities;
import ru.soviet.reg.RegItems;

public class EThingProjectile extends ThrowableItemProjectile {
    public EThingProjectile(EntityType<? extends EThingProjectile> type, Level level) {
        super(type, level);
    }

    public EThingProjectile(Level level, LivingEntity shooter) {
        super(RegEntities.E_THING_PROJECTILE.get(), shooter, level);
    }

    @Override
    protected Item getDefaultItem() {
        return RegItems.E_THING.get();
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        if (!level().isClientSide) {
            // Наносим урон 2
            result.getEntity().hurt(damageSources().thrown(this, getOwner()), 2.0f);
            dropItemWithChance();
            this.discard();
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        if (!level().isClientSide) {
            dropItemWithChance();
            this.discard();
        }
    }

    private void dropItemWithChance() {
        // 30% шанс выпадения предмета
        if (level().random.nextFloat() < 0.3f) {
            ItemStack stack = new ItemStack(getDefaultItem());
            ItemEntity itemEntity = new ItemEntity(level(), getX(), getY(), getZ(), stack);
            level().addFreshEntity(itemEntity);
        }
    }
}