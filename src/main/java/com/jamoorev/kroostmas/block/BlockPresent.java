package com.jamoorev.kroostmas.block;

import com.jamoorev.kroostmas.util.References;
import net.minecraft.block.material.Material;

/**
 * Created by Mitchellbrine on 2014.
 */
public class BlockPresent extends KroostmasBlock{

    public BlockPresent() {
        super(Material.cloth);
        this.setBlockName("present");
        this.setBlockTextureName(References.RESOURCEPREFIX + "present");
    }

}
