package com.jamoorev.kroostmas.block;

import com.jamoorev.kroostmas.KroostmasCraft;
import com.jamoorev.kroostmas.util.References;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mitchellbrine on 2014.
 */
public class BlockRegistry {

    public static List<Block> blocks = new ArrayList<Block>();

    public static Block present;


    public static void init() {

        present = new BlockPresent();

        // Make sure all the blocks are constructed before here
        registerAll();
    }

    private static void registerAll() {
        for (Block block : blocks) {
            GameRegistry.registerBlock(block,block.getUnlocalizedName().substring(5));
            KroostmasCraft.logger.info("Registered block " + block + " with the name " + block.getUnlocalizedName().substring(5));
            if (block.hasTileEntity(0)) {
                TileEntity entity = block.createTileEntity(null, 0);
                GameRegistry.registerTileEntity(entity.getClass(), References.RESOURCEPREFIX + block.getUnlocalizedName().substring(5) + "TE");
                KroostmasCraft.logger.info("Registered TileEntity " + entity + " with the name " + References.RESOURCEPREFIX + block.getUnlocalizedName().substring(5) + "TE");
            }
        }
    }

}
