package net.eddy0820.harmoniouscompats.client.event;

import com.mojang.datafixers.util.Pair;
import net.eddy0820.harmoniouscompats.HarmoniousCompats;
import net.eddy0820.harmoniouscompats.core.registry.ModTags;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectUtil;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = HarmoniousCompats.MOD_ID, value = Dist.CLIENT)
public class TooltipEvents
{
    @SubscribeEvent
    public static void addPositiveEffectTooltipToFoodItems(ItemTooltipEvent event) {

        ItemStack itemStack = event.getItemStack();

        if(!itemStack.is(ModTags.Items.FORCE_SHOW_POSITIVE_EFFECTS_FOODS))
            return;

        FoodProperties foodProperties = itemStack.getItem().getFoodProperties();

        if(foodProperties == null)
            return;

        List<Component> tooltip = event.getToolTip();

        int insertIndex= 1;
        for(int i = 0; i < tooltip.size(); i++)
        {
            if(tooltip.get(i).getString().isEmpty())
            {
                insertIndex = i;
                break;
            }
        }

        for(int i = 0; i < foodProperties.getEffects().size(); i++)
        {
            Pair<MobEffectInstance, Float> pair = foodProperties.getEffects().get(i);
            MobEffectInstance effect = pair.getFirst();

            if(effect.getEffect().getCategory() == MobEffectCategory.HARMFUL)
                continue;

            MutableComponent effectText = Component.translatable(effect.getDescriptionId());
            if (effect.getDuration() > 20) {
                effectText = Component.translatable("potion.withDuration", effectText, MobEffectUtil.formatDuration(effect, 1));
            }

            tooltip.add(insertIndex + i, effectText.withStyle(effect.getEffect().getCategory().getTooltipFormatting()));
        }
    }
}
