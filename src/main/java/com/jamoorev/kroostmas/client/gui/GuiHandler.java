package com.jamoorev.kroostmas.client.gui;

import com.jamoorev.kroostmas.container.ContainerPresent;
import com.jamoorev.kroostmas.tileentity.TileEntityPresent;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Mitchellbrine on 2014.
 */
public class GuiHandler implements IGuiHandler {

    public static class IDS {
        public static final int presentInv = 0;
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntity entity = world.getTileEntity(x, y, z);
        if (entity != null)
        {
            switch (ID)
            {
                case IDS.presentInv: return new ContainerPresent(player,(TileEntityPresent)entity);
            }
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntity entity = world.getTileEntity(x, y, z);
        if (entity != null) {
            switch (ID) {
                case IDS.presentInv:
                    return new GuiPresentInventory(player.inventory, (TileEntityPresent) entity);

            }
        }
        return null;
    }

}
