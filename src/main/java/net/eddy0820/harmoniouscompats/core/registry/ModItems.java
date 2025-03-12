package net.eddy0820.harmoniouscompats.core.registry;

import com.sammy.minersdelight.content.item.CopperCupFoodItem;
import com.sammy.minersdelight.setup.MDFoodValues;
import com.sammy.minersdelight.setup.MDItems;
import com.teamabnormals.neapolitan.core.registry.NeapolitanItems;
import net.eddy0820.harmoniouscompats.HarmoniousCompats;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.checkerframework.checker.units.qual.C;
import umpaz.nethersdelight.common.utility.NDFoods;
import vectorwing.farmersdelight.common.item.MushroomColonyItem;

public class ModItems
{
    public static void register(IEventBus eventBus)
    {
        if(HarmoniousCompats.ModsAreLoaded(HarmoniousCompats.MINERS_DELIGHT_MOD_ID, HarmoniousCompats.QUARK_DELIGHT_MOD_ID))
            QUARK_MINERSDELIGHT_ITEMS.register(eventBus);

        if(HarmoniousCompats.ModsAreLoaded(HarmoniousCompats.MINERS_DELIGHT_MOD_ID, HarmoniousCompats.NETHERS_DELIGHT_MOD_ID))
            NETHER_MINERSDELIGHT_ITEMS.register(eventBus);

        if(HarmoniousCompats.ModsAreLoaded(HarmoniousCompats.MINERS_DELIGHT_MOD_ID, HarmoniousCompats.NEAPOLITAN_MOD_ID))
            NEAPOLITAN_MINERSDELIGHT_ITEMS.register(eventBus);

        if(HarmoniousCompats.ModsAreLoaded(HarmoniousCompats.FARMERS_DELIGHT_MOD_ID, HarmoniousCompats.QUARK_MOD_ID))
            QUARK_FARMERSDELIGHT_ITEMS.register(eventBus);
    }

    public static final DeferredRegister<Item> QUARK_MINERSDELIGHT_ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, HarmoniousCompats.MOD_ID);

    public static final RegistryObject<CopperCupFoodItem> MISO_WITH_BAMBOO_SPROUTS_CUP = QUARK_MINERSDELIGHT_ITEMS.register("miso_with_bamboo_sprouts_cup",
            () -> new CopperCupFoodItem(new Item.Properties()
                    .food(MDFoodValues.cupFoodProperties(ModFoodValues.MISO_SOUP_WITH_BAMBOO_SPROUTS))
                    .craftRemainder(MDItems.COPPER_CUP.get())
                    .stacksTo(16), !ModFoodValues.MISO_SOUP_WITH_BAMBOO_SPROUTS.getEffects().isEmpty()));

    public static final RegistryObject<CopperCupFoodItem> CAVERN_EXPLORER_STEW_CUP = QUARK_MINERSDELIGHT_ITEMS.register("cavern_explorer_stew_cup",
            () -> new CopperCupFoodItem(new Item.Properties()
                    .food(MDFoodValues.cupFoodProperties(ModFoodValues.CAVERN_EXPLORER_STEW))
                    .craftRemainder(MDItems.COPPER_CUP.get())
                    .stacksTo(16), !ModFoodValues.CAVERN_EXPLORER_STEW.getEffects().isEmpty()));

    public static final DeferredRegister<Item> NETHER_MINERSDELIGHT_ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, HarmoniousCompats.MOD_ID);

    public static final RegistryObject<CopperCupFoodItem> STRIDER_MOSS_STEW_CUP = NETHER_MINERSDELIGHT_ITEMS.register("strider_moss_stew_cup",
            () -> new CopperCupFoodItem(new Item.Properties()
                    .food(MDFoodValues.cupFoodProperties(NDFoods.STRIDER_MOSS_STEW))
                    .craftRemainder(MDItems.COPPER_CUP.get())
                    .stacksTo(16), !NDFoods.STRIDER_MOSS_STEW.getEffects().isEmpty()));

    public static final DeferredRegister<Item> QUARK_FARMERSDELIGHT_ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, HarmoniousCompats.MOD_ID);

    public static final RegistryObject<Item> GLOW_SHROOM_COLONY = QUARK_FARMERSDELIGHT_ITEMS.register("glow_shroom_colony",
            () -> new MushroomColonyItem(ModBlocks.GLOW_SHROOM_COLONY.get(), new Item.Properties()));

    public static final DeferredRegister<Item> NEAPOLITAN_MINERSDELIGHT_ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, HarmoniousCompats.MOD_ID);

    public static final RegistryObject<CopperCupFoodItem> ADZUKI_CURRY_CUP = NEAPOLITAN_MINERSDELIGHT_ITEMS.register("adzuki_curry_cup",
            () -> new CopperCupFoodItem(new Item.Properties()
                    .food(MDFoodValues.cupFoodProperties(NeapolitanItems.NeapolitanFoods.ADZUKI_CURRY))
                    .craftRemainder(MDItems.COPPER_CUP.get())
                    .stacksTo(16), !NeapolitanItems.NeapolitanFoods.ADZUKI_CURRY.getEffects().isEmpty()));

    public static final RegistryObject<CopperCupFoodItem> ADZUKI_STEW_CUP = NEAPOLITAN_MINERSDELIGHT_ITEMS.register("adzuki_stew_cup",
            () -> new CopperCupFoodItem(new Item.Properties()
                    .food(MDFoodValues.cupFoodProperties(NeapolitanItems.NeapolitanFoods.ADZUKI_STEW))
                    .craftRemainder(MDItems.COPPER_CUP.get())
                    .stacksTo(16), !NeapolitanItems.NeapolitanFoods.ADZUKI_STEW.getEffects().isEmpty()));

}
