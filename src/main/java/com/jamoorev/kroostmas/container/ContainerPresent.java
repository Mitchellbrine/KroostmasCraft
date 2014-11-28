package com.jamoorev.kroostmas.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.IInventory;

/**
 * Created by Mitchellbrine on 2014.
 */
public class ContainerPresent extends ContainerChest {

    public ContainerPresent(EntityPlayer player, IInventory inventory) {
        super(player.inventory, inventory);
    }
}
