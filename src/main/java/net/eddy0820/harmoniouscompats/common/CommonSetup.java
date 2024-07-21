package net.eddy0820.harmoniouscompats.common;

import net.eddy0820.harmoniouscompats.HarmoniousCompats;
import net.eddy0820.harmoniouscompats.core.registry.ModItems;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class CommonSetup
{
    public static void init(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() ->
        {
            registerCompostables();
        });
    }

    public static void registerCompostables()
    {
        if(HarmoniousCompats.ModsAreLoaded(HarmoniousCompats.QUARK_MOD_ID, HarmoniousCompats.FARMERS_DELIGHT_MOD_ID))
            ComposterBlock.COMPOSTABLES.put(ModItems.GLOW_SHROOM_COLONY.get(), 1.0f);
    }
}
