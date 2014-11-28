package com.jamoorev.kroostmas.block;

import com.jamoorev.kroostmas.item.ItemRegistry;
import com.jamoorev.kroostmas.tileentity.TileEntityPresent;
import com.jamoorev.kroostmas.util.References;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

/**
 * Created by Mitchellbrine on 2014.
 */
public class BlockPresent extends KroostmasTileBlock{

    public BlockPresent() {
        super(Material.cloth);
        this.setBlockName("present");
        this.setBlockBounds(0.0625F,0.0F,0.0625F,0.9375F,0.875F,0.9375F);
    }


    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntityPresent();
    }

    @Override
    public TileEntity createTileEntity(World world, int meta) {
        return new TileEntityPresent();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        if (player.getCurrentEquippedItem() == null) {
            if (player.isSneaking()) {
                TileEntity tileEntity = world.getTileEntity(x,y,z);
                if (tileEntity instanceof TileEntityPresent) {
                    TileEntityPresent te = (TileEntityPresent)world.getTileEntity(x,y,z);
                    if (te.getOwner() == null) {
                        if (!world.isRemote) {
                            player.addChatComponentMessage(new ChatComponentTranslation("present.owner.set").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.LIGHT_PURPLE)));
                        }
                        te.setOwner(player.getGameProfile().getId());
                    }
                }
            } else {
                TileEntity tileEntity = world.getTileEntity(x,y,z);
                if (tileEntity instanceof TileEntityPresent) {
                    TileEntityPresent te = (TileEntityPresent) world.getTileEntity(x, y, z);
                    if ((te.getOwner() != null && te.getOwner().equals(player.getGameProfile().getId())) || te.getRecipient().equalsIgnoreCase(player.getCommandSenderName())) {
                        te.openChest(player);
                        // TODO: Create GUI and Container and Stuff
                    }
                }
            }
        } else {
            if (!player.isSneaking()) {
                TileEntity tileEntity = world.getTileEntity(x,y,z);
                if (tileEntity instanceof TileEntityPresent) {
                    TileEntityPresent te = (TileEntityPresent) world.getTileEntity(x, y, z);
                    if (player.getCurrentEquippedItem().getItem() == ItemRegistry.giftTag) {
                        te.setRecipient(player, player.getCurrentEquippedItem());
                    }
                }
            }
        }
        return true;
    }

    @Override
    public void registerBlockIcons(IIconRegister ir)
    {
        blockIcon = ir.registerIcon(References.RESOURCEPREFIX + "present");
    }

}
