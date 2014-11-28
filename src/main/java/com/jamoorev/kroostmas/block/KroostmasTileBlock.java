package com.jamoorev.kroostmas.block;

import com.jamoorev.kroostmas.KroostmasCraft;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;

/**
 * Created by Mitchellbrine on 2014.
 */
public abstract class KroostmasTileBlock extends BlockContainer{

    public KroostmasTileBlock(Material material) {
        super(material);
        this.setCreativeTab(KroostmasCraft.tab);

        BlockRegistry.blocks.add(this);
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public int getRenderType() {
        return -1;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

}
