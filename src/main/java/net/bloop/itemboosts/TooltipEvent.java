package net.bloop.itemboosts;

import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = ItemBoosts.MODID)
public class TooltipEvent {

    @SubscribeEvent
    public static void addTooltip(ItemTooltipEvent e) {
        ItemStack stack = e.getItemStack();
        if(stack.isEmpty())
            return;
        if(stack.hasTagCompound()) {
            if(stack.getTagCompound().hasKey("Augmented") && stack.getTagCompound().getInteger("Augmented") == 1) {
                e.getToolTip().add("This item is augmented");
            }
        }
    }
}
