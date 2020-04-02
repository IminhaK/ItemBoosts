package net.bloop.itemboosts.ItemEvents;

import net.bloop.itemboosts.ItemBoosts;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = ItemBoosts.MODID)
public class FeatherEvent {

    @SubscribeEvent
    public static void onFall(LivingFallEvent e) {
        if(!(e.getEntityLiving() instanceof EntityPlayer))
            return;
        ItemStack stack = e.getEntityLiving().getHeldItemMainhand();
        if(stack == ItemStack.EMPTY || stack.getItem() != Items.FEATHER || !stack.hasTagCompound())
            return;

        if(stack.getTagCompound().hasKey("Augmented") && stack.getTagCompound().getInteger("Augmented") == 1 && e.getDistance() > 3.25f) {
            stack.setCount(stack.getCount() - 1);
            e.setCanceled(true);
        }
    }
}
