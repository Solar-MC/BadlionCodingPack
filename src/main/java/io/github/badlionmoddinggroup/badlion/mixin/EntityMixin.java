package io.github.badlionmoddinggroup.badlion.mixin;

import io.github.badlionmoddinggroup.badlion.extra.EntityExtra;
import net.badlion.class_761;
import net.badlion.class_762;
import net.badlion.client.common.entity.EntityWrapper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Entity.class)
public class EntityMixin implements EntityExtra {

    public EntityWrapper badlionEntity;

    public EntityWrapper getBadlionEntity() {
        if (this.badlionEntity == null) {
            if (((Entity)(Object)this) instanceof PlayerEntity) {
                this.badlionEntity = new class_762((PlayerEntity) (Object)this);
            } else {
                this.badlionEntity = new class_761(((Entity)(Object)this));
            }
        }

        return this.badlionEntity;
    }

}
