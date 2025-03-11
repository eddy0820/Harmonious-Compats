package net.eddy0820.harmoniouscompats.core.mixin;

import com.google.gson.JsonElement;
import com.sammy.minersdelight.logic.CupConversionReloadListener;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CupConversionReloadListener.class)
public class CupConversionReloadListenerMixin
{
    @Inject(method = "itemFromJson", at = @At("HEAD"), cancellable = true, remap = false)
    private static void injectItemFromJson(JsonElement pItemObject, CallbackInfoReturnable<Item> cir) {
        String s = pItemObject.getAsJsonPrimitive().getAsString();
        Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(s));
        if (item == null || item == Items.AIR) {
            cir.setReturnValue(null);
        } else {
            cir.setReturnValue(item);
        }
    }
}
