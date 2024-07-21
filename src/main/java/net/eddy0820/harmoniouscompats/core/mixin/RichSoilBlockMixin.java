package net.eddy0820.harmoniouscompats.core.mixin;

import net.eddy0820.harmoniouscompats.HarmoniousCompats;
import net.eddy0820.harmoniouscompats.core.registry.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.TallFlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.violetmoon.quark.content.world.module.GlimmeringWealdModule;
import vectorwing.farmersdelight.common.block.RichSoilBlock;
import vectorwing.farmersdelight.common.tag.ModTags;

@Mixin(RichSoilBlock.class)
public class RichSoilBlockMixin
{
    @Inject(at = @At("HEAD"), method = "randomTick", cancellable = true)
    public void doGlowShroomColonyGrow(BlockState state, ServerLevel level, BlockPos pos, RandomSource rand, CallbackInfo cir)
    {
        if(HarmoniousCompats.ModsAreLoaded(HarmoniousCompats.QUARK_MOD_ID, HarmoniousCompats.FARMERS_DELIGHT_MOD_ID))
        {
            if(!level.isClientSide)
            {
                BlockPos abovePos = pos.above();
                BlockState aboveState = level.getBlockState(abovePos);
                Block aboveBlock = aboveState.getBlock();

                // Do nothing if the plant is unaffected by rich soil
                if (aboveState.is(ModTags.UNAFFECTED_BY_RICH_SOIL) || aboveBlock instanceof TallFlowerBlock) {
                    cir.cancel();
                }

                // Convert mushrooms to colonies if it's dark enough
                if (aboveBlock == GlimmeringWealdModule.glow_shroom) {
                    level.setBlockAndUpdate(pos.above(), ModBlocks.GLOW_SHROOM_COLONY.get().defaultBlockState());
                    cir.cancel();
                }
            }
        }
    }
}
