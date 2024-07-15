package net.eddy0820.harmoniouscompats.core.registry;

import com.sammy.minersdelight.content.item.CopperCupFoodItem;
import com.sammy.minersdelight.setup.MDFoodValues;
import com.sammy.minersdelight.setup.MDItems;
import net.eddy0820.harmoniouscompats.HarmoniousCompats;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import umpaz.nethersdelight.common.utility.NDFoods;

public class ModItems
{
    public static void register(IEventBus eventBus)
    {
        if(HarmoniousCompats.ModsAreLoaded(HarmoniousCompats.MINERS_DELIGHT_MOD_ID, HarmoniousCompats.QUARK_DELIGHT_MOD_ID))
            QUARKMINERSDELIGHTITEMS.register(eventBus);

        if(HarmoniousCompats.ModsAreLoaded(HarmoniousCompats.MINERS_DELIGHT_MOD_ID, HarmoniousCompats.NETHERS_DELIGHT_MOD_ID))
            NETHERMINERSDELIGHTITEMS.register(eventBus);
    }

    public static final DeferredRegister<Item> QUARKMINERSDELIGHTITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, HarmoniousCompats.MOD_ID);

    public static final RegistryObject<CopperCupFoodItem> MISO_WITH_BAMBOO_SPROUTS_CUP = QUARKMINERSDELIGHTITEMS.register("miso_with_bamboo_sprouts_cup",
            () -> new CopperCupFoodItem(new Item.Properties()
                    .food(MDFoodValues.cupFoodProperties(ModFoodValues.MISO_SOUP_WITH_BAMBOO_SPROUTS))
                    .craftRemainder(MDItems.COPPER_CUP.get())
                    .stacksTo(16), !ModFoodValues.MISO_SOUP_WITH_BAMBOO_SPROUTS.getEffects().isEmpty()));

    public static final RegistryObject<CopperCupFoodItem> CAVERN_EXPLORER_STEW_CUP = QUARKMINERSDELIGHTITEMS.register("cavern_explorer_stew_cup",
            () -> new CopperCupFoodItem(new Item.Properties()
                    .food(MDFoodValues.cupFoodProperties(ModFoodValues.CAVERN_EXPLORER_STEW))
                    .craftRemainder(MDItems.COPPER_CUP.get())
                    .stacksTo(16), !ModFoodValues.CAVERN_EXPLORER_STEW.getEffects().isEmpty()));

    public static final DeferredRegister<Item> NETHERMINERSDELIGHTITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, HarmoniousCompats.MOD_ID);

    public static final RegistryObject<CopperCupFoodItem> STRIDER_MOSS_STEW_CUP = NETHERMINERSDELIGHTITEMS.register("strider_moss_stew_cup",
            () -> new CopperCupFoodItem(new Item.Properties()
                    .food(MDFoodValues.cupFoodProperties(NDFoods.STRIDER_MOSS_STEW))
                    .craftRemainder(MDItems.COPPER_CUP.get())
                    .stacksTo(16), !NDFoods.STRIDER_MOSS_STEW.getEffects().isEmpty()));
}
