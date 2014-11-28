package com.jamoorev.kroostmas.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Created by Mitchellbrine on 2014.
 */
public abstract class KroostmasBlock extends Block{

    public KroostmasBlock(Material material) {
        super(material);
        BlockRegistry.blocks.add(this);
    }

}
