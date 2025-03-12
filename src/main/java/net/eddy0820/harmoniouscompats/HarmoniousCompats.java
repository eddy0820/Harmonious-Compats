package net.eddy0820.harmoniouscompats;

import com.mojang.logging.LogUtils;
import net.eddy0820.harmoniouscompats.common.CommonSetup;
import net.eddy0820.harmoniouscompats.core.registry.ModBlocks;
import net.eddy0820.harmoniouscompats.core.registry.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(HarmoniousCompats.MOD_ID)
public class HarmoniousCompats {
    public static final String MOD_ID = "harmoniouscompats";
    public static final String MINERS_DELIGHT_MOD_ID = "miners_delight";
    public static final String QUARK_DELIGHT_MOD_ID = "quarkdelight";
    public static final String NETHERS_DELIGHT_MOD_ID = "nethersdelight";
    public static final String QUARK_MOD_ID = "quark";
    public static final String FARMERS_DELIGHT_MOD_ID = "farmersdelight";
    public static final String NEAPOLITAN_MOD_ID = "neapolitan";
    public static final String SAVAGE_AND_RAVAGE_MOD_ID = "savage_and_ravage";

    public static final Logger LOGGER = LogUtils.getLogger();

    public HarmoniousCompats() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(CommonSetup::init);
        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS)
        {
            if(ModsAreLoaded(MINERS_DELIGHT_MOD_ID, QUARK_DELIGHT_MOD_ID))
            {
                event.accept(ModItems.MISO_WITH_BAMBOO_SPROUTS_CUP);
                event.accept(ModItems.CAVERN_EXPLORER_STEW_CUP);
            }

            if(ModsAreLoaded(MINERS_DELIGHT_MOD_ID, NETHERS_DELIGHT_MOD_ID))
            {
                event.accept(ModItems.STRIDER_MOSS_STEW_CUP);
            }

            if(ModsAreLoaded(MINERS_DELIGHT_MOD_ID, NEAPOLITAN_MOD_ID))
            {
                event.accept(ModItems.ADZUKI_CURRY_CUP);
                event.accept(ModItems.ADZUKI_STEW_CUP);
            }
        }
        if(event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS)
        {
            if(ModsAreLoaded(FARMERS_DELIGHT_MOD_ID, QUARK_MOD_ID))
            {
                event.accept(ModItems.GLOW_SHROOM_COLONY);
            }
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }

    public static Boolean ModsAreLoaded(String... modIDs)
    {
        for(String modID : modIDs)
        {
            if(!ModList.get().isLoaded(modID))
            {
                return false;
            }
        }

        return true;
    }
}