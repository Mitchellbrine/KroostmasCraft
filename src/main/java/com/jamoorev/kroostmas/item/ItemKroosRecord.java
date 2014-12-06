package com.jamoorev.kroostmas.item;

import com.jamoorev.kroostmas.KroostmasCraft;
import com.jamoorev.kroostmas.util.References;
import net.minecraft.item.ItemRecord;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Mitchellbrine on 2014.
 */
public class ItemKroosRecord extends ItemRecord {

    protected ItemKroosRecord(String name,String resourceName) {
        super(name);
        this.setCreativeTab(KroostmasCraft.tab);
        this.setUnlocalizedName(name);
        this.setTextureName(References.RESOURCEPREFIX + "record_" + name);
        this.getRecordResource(resourceName);
        ItemRegistry.items.add(this);
    }

    @Override
    public ResourceLocation getRecordResource(String name)
    {
        return new ResourceLocation(References.MODID.toLowerCase(), name);
    }
}
