package net.eddy0820.harmoniouscompats.core.registry;

import net.eddy0820.harmoniouscompats.HarmoniousCompats;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.violetmoon.quark.content.world.module.GlimmeringWealdModule;
import vectorwing.farmersdelight.common.block.MushroomColonyBlock;

public class ModBlocks
{
    public static void register(IEventBus eventBus)
    {
        if(HarmoniousCompats.ModsAreLoaded(HarmoniousCompats.FARMERS_DELIGHT_MOD_ID, HarmoniousCompats.QUARK_MOD_ID))
            QUARK_FARMERSDELIGHT_BLOCKS.register(eventBus);
    }

    public static final DeferredRegister<Block> QUARK_FARMERSDELIGHT_BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, HarmoniousCompats.MOD_ID);

    public static final RegistryObject<Block> GLOW_SHROOM_COLONY = QUARK_FARMERSDELIGHT_BLOCKS.register("glow_shroom_colony",
            () -> new MushroomColonyBlock(BlockBehaviour.Properties.copy(GlimmeringWealdModule.glow_shroom_block), () -> GlimmeringWealdModule.glow_shroom.asItem()));

}
