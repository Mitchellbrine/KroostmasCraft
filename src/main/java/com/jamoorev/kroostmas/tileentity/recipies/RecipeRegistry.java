package com.jamoorev.kroostmas.tileentity.recipies;

import com.jamoorev.kroostmas.block.BlockRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;

/**
 * Created by Mitchellbrine on 2014.
 */
public class RecipeRegistry {

    public static void init() {
        GameRegistry.addRecipe(new ItemStack(BlockRegistry.present),"SSS","WCW","WWW",'S', Items.string,'W',new ItemStack(Blocks.wool,1, 14),'C',Blocks.chest);
    }

}
