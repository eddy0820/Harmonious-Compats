package net.eddy0820.harmoniouscompats.core.mixin;

import com.teamabnormals.savage_and_ravage.common.levelgen.feature.EnclosureFeature;
import net.eddy0820.harmoniouscompats.HarmoniousCompats;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EnclosureFeature.class)
public class EnclosureFeatureMixin
{
    @Redirect(method = "generateDecorations", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Blocks;CHEST:Lnet/minecraft/world/level/block/Block;"))
    private Block getBlock()
    {
        if(!HarmoniousCompats.ModsAreLoaded(HarmoniousCompats.QUARK_MOD_ID, HarmoniousCompats.SAVAGE_AND_RAVAGE_MOD_ID))
            return Blocks.CHEST;

        return ForgeRegistries.BLOCKS.getValue(new ResourceLocation("quark", "dark_oak_chest"));
    }
}
