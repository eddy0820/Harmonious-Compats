package net.eddy0820.harmoniouscompats.core.registry;

import net.eddy0820.harmoniouscompats.HarmoniousCompats;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModTags
{
    public static class Items
    {
        public static final TagKey<Item> FORCE_SHOW_POSITIVE_EFFECTS_FOODS = tag("force_show_positive_effects_foods");

        private static TagKey<Item> tag(String name)
        {
            return ItemTags.create(new ResourceLocation(HarmoniousCompats.MOD_ID, name));
        }
    }
}
