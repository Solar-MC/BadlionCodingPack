package io.github.badlionmoddinggroup.badlion.mixin;

import com.mojang.authlib.GameProfile;
import io.github.badlionmoddinggroup.badlion.extra.PlayerEntityExtra;
import net.badlion.client.common.BadlionClient;
import net.badlion.client.common.manager.model.ModelManager;
import net.badlion.client.cosmetics.emotes.AnimatorController;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin implements PlayerEntityExtra {

    AnimatorController controller;

    @Override
    public AnimatorController getController() {
        return controller;
    }

    @Inject(method = "<init>", at = @At("TAIL"))
    public void constructor(World world, GameProfile profile, CallbackInfo ci){
        ModelManager modelManager = BadlionClient.getBadlion().getModelManager();
        this.controller = new AnimatorController(modelManager.field_2563, modelManager.field_2565);
    }


}
