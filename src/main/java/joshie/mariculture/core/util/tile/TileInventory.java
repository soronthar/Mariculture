package joshie.mariculture.core.util.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.INBTSerializable;

import static net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY;

public abstract class TileInventory extends TileMC {
    protected abstract INBTSerializable<NBTTagCompound> getInventory();

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        return capability == ITEM_HANDLER_CAPABILITY || super.hasCapability(capability, facing);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        if (facing != null && capability == ITEM_HANDLER_CAPABILITY)
            return (T) getInventory();
        return super.getCapability(capability, facing);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound)  {
        super.readFromNBT(compound);
        getInventory().deserializeNBT(compound.getCompoundTag("Inventory"));
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setTag("Inventory", getInventory().serializeNBT());
        return super.writeToNBT(compound);
    }
}
