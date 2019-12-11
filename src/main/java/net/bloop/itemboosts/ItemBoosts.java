package net.bloop.itemboosts;

import net.minecraftforge.fml.common.Mod;

@Mod(modid = ItemBoosts.MODID, name = ItemBoosts.NAME, version = ItemBoosts.VERSION)
public class ItemBoosts {

    public static final String MODID = "itemboosts";
    public static final String NAME = "Item Boost";
    public static final String VERSION = "1.0";

    @Mod.Instance(ItemBoosts.MODID)
    public static ItemBoosts instance;
}
