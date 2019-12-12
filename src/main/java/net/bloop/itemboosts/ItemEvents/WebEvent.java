package net.bloop.itemboosts.ItemEvents;

import net.bloop.itemboosts.ItemBoosts;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = ItemBoosts.MODID)
public class WebEvent {

    @SubscribeEvent
    public static void onToss(ItemTossEvent e) {
        if(e.getPlayer() == null)
            return;
        if(e.getEntityItem() == null || e.getEntityItem().getItem().getItem() != Item.getItemFromBlock(Blocks.WEB))
            return;
        EntityPlayer player = e.getPlayer();
        ItemStack stack = e.getEntityItem().getItem();
        if(!stack.hasTagCompound())
            return;
        if(stack.getTagCompound().hasKey("Augmented") && stack.getTagCompound().getInteger("Augmented") == 1 && player.isSneaking()) {
            Vec3d looking = player.getLookVec();
            player.addVelocity(1.0 * looking.x, 1.0 * looking.y, 1.0 * looking.z);
            player.velocityChanged = true;
            e.setCanceled(true);
        }

    }
}
