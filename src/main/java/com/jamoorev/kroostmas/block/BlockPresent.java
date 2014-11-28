package com.jamoorev.kroostmas.block;

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
        this.setBlockTextureName(References.RESOURCEPREFIX + "present");
        this.setBlockBounds(0.0625F,0.0F,0.0625F,0.9375F,0.9375F,0.9375F);
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public int getRenderType() {
        return 0;
    }

    public boolean renderAsNormalBlock() {
        return false;
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
                    te.openSettings();
                    // TODO: Create GUI for setting recipient
                }
            } else {
                // TODO: Create GUI and Container and Stuff
                TileEntity tileEntity = world.getTileEntity(x,y,z);
                if (tileEntity instanceof TileEntityPresent) {
                    TileEntityPresent te = (TileEntityPresent) world.getTileEntity(x, y, z);
                    te.openChest();
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public void registerBlockIcons(IIconRegister ir)
    {
        blockIcon = ir.registerIcon(References.RESOURCEPREFIX + "machines/wandCarverIcon");
    }

}
