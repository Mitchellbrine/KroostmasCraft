package com.jamoorev.kroostmas.tileentity.recipies;

import com.jamoorev.kroostmas.block.BlockRegistry;
import com.jamoorev.kroostmas.item.ItemRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 * Created by Mitchellbrine on 2014.
 */
public class RecipeRegistry {

    public static void init() {
        GameRegistry.addRecipe(new ItemStack(BlockRegistry.present),"SSS","WCW","WWW",'S', Items.string,'W',new ItemStack(Blocks.wool,1, 14),'C',Blocks.chest);

        GameRegistry.addRecipe(new ItemStack(ItemRegistry.rickRecord),"ggg","gRg","ggg",'g',Items.gold_ingot,'R',Items.record_11);
        GameRegistry.addRecipe(new ItemStack(ItemRegistry.rickRecord),"ggg","gRg","ggg",'g',Items.gold_ingot,'R',Items.record_13);
        GameRegistry.addRecipe(new ItemStack(ItemRegistry.rickRecord),"ggg","gRg","ggg",'g',Items.gold_ingot,'R',Items.record_blocks);
        GameRegistry.addRecipe(new ItemStack(ItemRegistry.rickRecord),"ggg","gRg","ggg",'g',Items.gold_ingot,'R',Items.record_cat);
        GameRegistry.addRecipe(new ItemStack(ItemRegistry.rickRecord),"ggg","gRg","ggg",'g',Items.gold_ingot,'R',Items.record_chirp);
        GameRegistry.addRecipe(new ItemStack(ItemRegistry.rickRecord),"ggg","gRg","ggg",'g',Items.gold_ingot,'R',Items.record_far);
        GameRegistry.addRecipe(new ItemStack(ItemRegistry.rickRecord),"ggg","gRg","ggg",'g',Items.gold_ingot,'R',Items.record_mall);
        GameRegistry.addRecipe(new ItemStack(ItemRegistry.rickRecord),"ggg","gRg","ggg",'g',Items.gold_ingot,'R',Items.record_mellohi);
        GameRegistry.addRecipe(new ItemStack(ItemRegistry.rickRecord),"ggg","gRg","ggg",'g',Items.gold_ingot,'R',Items.record_stal);
        GameRegistry.addRecipe(new ItemStack(ItemRegistry.rickRecord),"ggg","gRg","ggg",'g',Items.gold_ingot,'R',Items.record_strad);
        GameRegistry.addRecipe(new ItemStack(ItemRegistry.rickRecord),"ggg","gRg","ggg",'g',Items.gold_ingot,'R',Items.record_ward);
        GameRegistry.addRecipe(new ItemStack(ItemRegistry.rickRecord),"ggg","gRg","ggg",'g',Items.gold_ingot,'R',Items.record_wait);
        GameRegistry.addRecipe(new ItemStack(ItemRegistry.rickRecord),"ggg","gRg","ggg",'g',Items.gold_ingot,'R',ItemRegistry.nyanRecord);

        GameRegistry.addRecipe(new ItemStack(ItemRegistry.nyanRecord),"roy","gRG","bip",'r',new ItemStack(Blocks.wool, 1,14),'o',new ItemStack(Blocks.wool, 1,1),'y',new ItemStack(Blocks.wool, 1,4),'g',new ItemStack(Blocks.wool, 1,5),'G',new ItemStack(Blocks.wool, 1,7),'b',new ItemStack(Blocks.wool, 1,11),'i',new ItemStack(Blocks.wool, 1,2),'p',new ItemStack(Blocks.wool, 1,10),'R',Items.record_mellohi);

        GameRegistry.addRecipe(new ItemStack(ItemRegistry.spoonRecord),"OOO","OrS","SSS",'O',new ItemStack(Blocks.planks,1,0),'S',new ItemStack(Blocks.planks,1,1),'r',ItemRegistry.rickRecord);
        GameRegistry.addRecipe(new ItemStack(ItemRegistry.spoonRecord),"OOO","OrS","SSS",'O',new ItemStack(Blocks.planks,1,0),'S',new ItemStack(Blocks.planks,1,1),'r',ItemRegistry.nyanRecord);
        GameRegistry.addRecipe(new ItemStack(ItemRegistry.spoonRecord),"OOO","OrS","SSS",'O',new ItemStack(Blocks.planks,1,0),'S',new ItemStack(Blocks.planks,1,1),'r',ItemRegistry.allBeGoneRecord);

    }

}
