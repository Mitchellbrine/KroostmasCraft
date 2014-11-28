package com.jamoorev.kroostmas.block;

import com.jamoorev.kroostmas.KroostmasCraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Created by Mitchellbrine on 2014.
 */
public abstract class KroostmasBlock extends Block{

    public KroostmasBlock(Material material) {
        super(material);
        this.setCreativeTab(KroostmasCraft.tab);
        BlockRegistry.blocks.add(this);
    }

}
