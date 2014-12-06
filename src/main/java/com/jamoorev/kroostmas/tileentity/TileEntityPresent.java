package com.jamoorev.kroostmas.tileentity;

import com.jamoorev.kroostmas.KroostmasCraft;
import com.jamoorev.kroostmas.client.gui.GuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;

import java.util.UUID;

/**
 * Created by Mitchellbrine on 2014.
 */
public class TileEntityPresent extends TileEntity implements ISidedInventory, IInventory {

    private UUID uuid;
    private String recipient, ownerName;
    public ItemStack[] items = new ItemStack[27];

        public TileEntityPresent() {
            recipient = "";
            ownerName = "";
        }

    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        if (uuid != null) {
            nbt.setString("owner", uuid.toString());
        }
        if (!recipient.equals("")) {
            nbt.setString("recipient",recipient);
        }
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.items.length; ++i)
        {
            if (this.items[i] != null)
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                this.items[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }

        nbt.setTag("Items", nbttaglist);
    }

    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        if (nbt.hasKey("owner")) {
            uuid = UUID.fromString(nbt.getString("owner"));
        }
        if (nbt.hasKey("recipient")) {
            recipient = nbt.getString("recipient");
        }
        NBTTagList nbttaglist = nbt.getTagList("Items", 10);
        this.items = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i)
        {
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            byte b0 = nbttagcompound1.getByte("Slot");

            if (b0 >= 0 && b0 < this.items.length)
            {
                this.items[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }
    }

    public String getRecipient() {
        return this.recipient;
    }

    public UUID getOwner() {
        return this.uuid;
    }

    public void setOwner(EntityPlayer player) {
        this.uuid = player.getGameProfile().getId();
        this.ownerName = player.getCommandSenderName();

    }

    public void openChest(EntityPlayer player) {
        player.openGui(KroostmasCraft.instance, GuiHandler.IDS.presentInv,worldObj,xCoord,yCoord,zCoord);
        KroostmasCraft.logger.error("TODO: Create GUI and Container and Stuff");
    }

    public void setRecipient(EntityPlayer player, ItemStack stack) {
        if (!stack.getDisplayName().equalsIgnoreCase("Gift Tag")) {
            if (player.getGameProfile().getId().equals(this.uuid)) {
                this.recipient = EnumChatFormatting.getTextWithoutFormattingCodes(stack.getDisplayName());
                stack = null;
                if (!player.worldObj.isRemote)
                    player.addChatComponentMessage(new ChatComponentTranslation("present.recipient.set", this.recipient).setChatStyle(new ChatStyle().setColor(EnumChatFormatting.LIGHT_PURPLE)));
            }
        }
    }

    @Override
    public int getSizeInventory()
    {
        return 27;
    }

    @Override
    public ItemStack getStackInSlot(int var1)
    {
        return this.items[var1];
    }

    @Override
    public ItemStack decrStackSize(int var1, int var2)
    {
        if (this.items[var1] != null)
        {
            ItemStack itemstack;

            if (this.items[var1].stackSize <= var2)
            {
                itemstack = this.items[var1];
                this.items[var1] = null;
                this.markDirty();
                return itemstack;
            }
            else
            {
                itemstack = this.items[var1].splitStack(var2);

                if (this.items[var1].stackSize == 0)
                {
                    this.items[var1] = null;
                }

                this.markDirty();
                return itemstack;
            }
        }
        else
        {
            return null;
        }
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int var1)
    {
        if (this.items[var1] != null)
        {
            ItemStack itemstack = this.items[var1];
            this.items[var1] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
    }

    @Override
    public void setInventorySlotContents(int var1, ItemStack var2)
    {
        this.items[var1] = var2;

        if (var2 != null && var2.stackSize > this.getInventoryStackLimit())
        {
            var2.stackSize = this.getInventoryStackLimit();
        }

        this.markDirty();
    }

    public int setFirstEmpty(ItemStack p_146019_1_)
    {
        for (int i = 0; i < this.items.length; ++i)
        {
            if (this.items[i] == null || this.items[i].getItem() == null)
            {
                this.setInventorySlotContents(i, p_146019_1_);
                return i;
            }
        }

        return -1;
    }

    @Override
    public String getInventoryName()
    {
        return "Kroostmas Present";
    }

    @Override
    public boolean hasCustomInventoryName()
    {
        return true;
    }

    @Override
    public int getInventoryStackLimit()
    {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer var1)
    {
        return true;
    }

    @Override
    public void openInventory()
    {
    }

    @Override
    public void closeInventory()
    {
    }

    @Override
    public boolean isItemValidForSlot(int var1, ItemStack var2)
    {
        return false;
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int var1)
    {
        return null;
    }

    @Override
    public boolean canInsertItem(int var1, ItemStack var2, int var3)
    {
        return false;
    }

    @Override
    public boolean canExtractItem(int var1, ItemStack var2, int var3)
    {
        return false;
    }

    public ItemStack[] getItems() {
        return items;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getOwnerName() {
        return this.ownerName;
    }

}
