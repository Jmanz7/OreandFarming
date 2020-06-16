package io.github.jmanz7.oreandfarming.item;

import io.github.jmanz7.oreandfarming.OreandFarming;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class HeatedIronIngotItem extends Item
{
    public HeatedIronIngotItem(Properties properties)
    {
        super(properties);
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
    {
        if (isSelected) entityIn.attackEntityFrom(OreandFarming.HEATED_IRON_INGOT, 1);
    }
}
