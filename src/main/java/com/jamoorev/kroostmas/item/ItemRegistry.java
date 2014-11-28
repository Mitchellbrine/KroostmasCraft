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

    public static void init() {



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
