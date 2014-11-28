package com.jamoorev.kroostmas.item;

import com.jamoorev.kroostmas.KroostmasCraft;
import net.minecraft.item.Item;

/**
 * Created by Mitchellbrine on 2014.
 */
public abstract class KroostmasItem extends Item{

    public KroostmasItem() {
        super();
        this.setCreativeTab(KroostmasCraft.tab);
        ItemRegistry.items.add(this);
    }

}
