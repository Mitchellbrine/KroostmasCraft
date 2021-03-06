package com.jamoorev.kroostmas.item;

import com.jamoorev.kroostmas.KroostmasCraft;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mitchellbrine on 2014.
 */
public class ItemRegistry {

    public static List<Item> items = new ArrayList<Item>();

    public static Item giftTag;
    public static Item rickRecord;
    public static Item nyanRecord;
    public static Item allBeGoneRecord;
    public static Item spoonRecord;
    public static Item totalRecord;
    public static Item halfLifeRecord;

    public static void init() {

        giftTag = new GiftTag();
        rickRecord = new ItemKroosRecord("rick","rick");
        nyanRecord = new ItemKroosRecord("nyan","nyan");
        allBeGoneRecord = new ItemKroosRecord("allbegone","allbegone");
        spoonRecord = new ItemKroosRecord("spoon","spoon");
        totalRecord = new ItemKroosRecord("uwot","uwot");
        halfLifeRecord = new ItemKroosRecord("halflife","halflife");

        // All items need to be registered before this!
        registerAll();
    }

    private static void registerAll() {
        for (Item item : items) {
            GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
            KroostmasCraft.logger.info("Registered item " + item + " with the name " + item.getUnlocalizedName().substring(5));
        }
    }

}
