package com.jamoorev.kroostmas.block;

import com.jamoorev.kroostmas.item.ItemRegistry;
import com.jamoorev.kroostmas.tileentity.TileEntityPresent;
import com.jamoorev.kroostmas.util.References;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by Mitchellbrine on 2014.
 */
public class BlockPresent extends KroostmasTileBlock{

    public BlockPresent() {
        super(Material.cloth);
        this.setBlockName("present");
        this.setHardness(2.0F);
        this.setStepSound(Block.soundTypeCloth);
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
            if (player.isSneaking()) {
                TileEntity tileEntity = world.getTileEntity(x,y,z);
                if (tileEntity instanceof TileEntityPresent) {
                    TileEntityPresent te = (TileEntityPresent)world.getTileEntity(x,y,z);
                    if (player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == ItemRegistry.giftTag) {
                        te.setRecipient(player, player.getCurrentEquippedItem());
                    } else {
                        if (te.getOwner() == null) {
                            if (!world.isRemote) {
                                player.addChatComponentMessage(new ChatComponentTranslation("present.owner.set").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.LIGHT_PURPLE)));
                            }
                            te.setOwner(player);
                        }
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
        return true;
    }

    public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
        TileEntityPresent te = (TileEntityPresent) world.getTileEntity(x, y, z);

        if (te != null) {
            for (int i1 = 0; i1 < te.getSizeInventory(); ++i1) {
                ItemStack itemstack = te.getStackInSlot(i1);

                if (itemstack != null) {

                    Random random = new Random(world.getWorldTime());

                    float f = random.nextFloat() * 0.8F + 0.1F;
                    float f1 = new Random(world.getWorldTime()).nextFloat() * 0.8F + 0.1F;
                    EntityItem entityitem;

                    for (float f2 = random.nextFloat() * 0.8F + 0.1F; itemstack.stackSize > 0; world.spawnEntityInWorld(entityitem)) {
                        int j1 = random.nextInt(21) + 10;

                        if (j1 > itemstack.stackSize) {
                            j1 = itemstack.stackSize;
                        }

                        itemstack.stackSize -= j1;
                        entityitem = new EntityItem(world, (double) ((float) x + f), (double) ((float) y + f1), (double) ((float) z + f2), new ItemStack(itemstack.getItem(), j1, itemstack.getItemDamage()));
                        float f3 = 0.05F;
                        entityitem.motionX = (double) ((float) random.nextGaussian() * f3);
                        entityitem.motionY = (double) ((float) random.nextGaussian() * f3 + 0.2F);
                        entityitem.motionZ = (double) ((float) random.nextGaussian() * f3);

                        if (itemstack.hasTagCompound()) {
                            entityitem.getEntityItem().setTagCompound((NBTTagCompound) itemstack.getTagCompound().copy());
                        }
                    }
                }
            }

            world.func_147453_f(x, y, z, block);
        }
    }

    @Override
    public void registerBlockIcons(IIconRegister ir)
    {
        blockIcon = ir.registerIcon(References.RESOURCEPREFIX + "present");
    }

}
