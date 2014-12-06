package com.jamoorev.kroostmas.compat.waila;

//import com.jamoorev.kroostmas.tileentity.TileEntityPresent;
//import mcp.mobius.waila.api.IWailaConfigHandler;
//import mcp.mobius.waila.api.IWailaDataAccessor;
//import mcp.mobius.waila.api.IWailaDataProvider;
//import net.minecraft.block.Block;
//import net.minecraft.item.ItemStack;
//import net.minecraft.tileentity.TileEntity;

//import java.util.List;

/**
 * Created by Mitchellbrine on 2014.
 */
public class PresentProvider /*implements IWailaDataProvider*/ {

    /*
    @Override
    public ItemStack getWailaStack(IWailaDataAccessor accessor, IWailaConfigHandler configHandler)
    {
        return null;
    }

    @Override
    public List<String> getWailaHead(ItemStack itemStack, List<String> list, IWailaDataAccessor iWailaDataAccessor, IWailaConfigHandler iWailaConfigHandler) {
        return list;
    }

    @Override
    public List<String> getWailaBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config)
    {
        TileEntity tileEntity = accessor.getTileEntity();
        if (tileEntity instanceof TileEntityPresent) {
            TileEntityPresent te = (TileEntityPresent) tileEntity;
            if (te.getOwner() != null) {
                if (accessor.getPlayer().getGameProfile().getId().equals(te.getOwner())) {
                    currenttip.add("From: You");
                } else {
                    if (!te.getOwnerName().equals("")) {
                        currenttip.add("From: " + te.getOwnerName());
                    }
                }
            }
            if (accessor.getPlayer().getCommandSenderName().equalsIgnoreCase(te.getRecipient())) {

            } else {
                if (!te.getRecipient().equals("")) {
                    currenttip.add("To: " + te.getRecipient());
                } else {
                    currenttip.add("To: You");
                }
            }
        }
        return currenttip;
    }

    @Override
    public List<String> getWailaTail(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config)
    {
        return currenttip;
    } */

}
