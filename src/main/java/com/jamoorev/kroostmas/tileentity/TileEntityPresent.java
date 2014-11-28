package com.jamoorev.kroostmas.tileentity;

import com.jamoorev.kroostmas.KroostmasCraft;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

import java.util.UUID;

/**
 * Created by Mitchellbrine on 2014.
 */
public class TileEntityPresent extends TileEntity {

    private UUID uuid;
    private String recipient;

        public TileEntityPresent() {
            recipient = "";
        }

    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        if (uuid != null) {
            nbt.setString("owner", uuid.toString());
        }
        if (!recipient.equals("")) {
            nbt.setString("recipient",recipient);
        }
    }

    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        if (nbt.hasKey("owner")) {
            uuid = UUID.fromString(nbt.getString("owner"));
        }
        if (nbt.hasKey("recipient")) {
            recipient = nbt.getString("recipient");
        }
    }

    public String getRecipient() {
        return this.recipient;
    }

    public UUID getOwner() {
        return this.uuid;
    }

    public void setOwner(UUID uuid) {
        this.uuid = uuid;
    }

    public void openChest() {
        KroostmasCraft.logger.error("TODO: Create GUI and Container and Stuff");
    }

    public void openSettings() {
        KroostmasCraft.logger.error("TODO: Create GUI and Stuff");
    }

}
