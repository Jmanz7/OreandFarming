package io.github.jmanz7.oreandfarming.items;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
 
public class DrillItem extends PickaxeItem
{
    private DrillTier tier;
   
    public DrillItem(DrillTier tier, Properties builder)
    {
        super(tier, 1, -2.8F, builder);
        this.tier = tier;
    }
    
    public DrillTier getTier()
    {
    	return this.tier;
    }
    
    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state)
    {
        return super.getDestroySpeed(stack, state) / 3;
    }
   
    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving)
    {
        if (!worldIn.isRemote)
        {
            Direction.Axis axis = entityLiving.getHorizontalFacing().getAxis();
           
            if (entityLiving.rotationPitch < -45 || entityLiving.rotationPitch > 45) axis = Direction.Axis.Y;
           
            int side = tier.getMiningSize() / 2;
            for (int x = -side; x <= side; x++)
            {
                for (int y = -side; y <= side; y++)
                {
                    if (x == 0 && y == 0) continue;
                   
                    BlockPos destroyPos;
                    switch(axis)
                    {
                    case X: destroyPos = pos.add(0, y, x); break;
                    case Y: destroyPos = pos.add(x, 0, y); break;
                    case Z: destroyPos = pos.add(x, y, 0); break;
                   
                    default: destroyPos = pos;
                    }
                   
                    BlockState destroyState = worldIn.getBlockState(destroyPos);
                    boolean drop = destroyState.canHarvestBlock(worldIn, destroyPos, (PlayerEntity)entityLiving);
                    if (destroyState.getBlockHardness(worldIn, destroyPos) >= 0) worldIn.destroyBlock(destroyPos, drop);
                }
            }
           
            stack.damageItem(1, entityLiving, (entity) ->
            {
                entity.sendBreakAnimation(Hand.MAIN_HAND);
            });
           
            return true;
        }
       
        return false;
    }
   
    public enum DrillTier implements IItemTier
    {
        IRON(3, 2, 80, 6.0F, 2.0F, 14, Items.IRON_INGOT),
        DIAMOND(5, 3, 100, 8.0F, 3.0F, 10, Items.DIAMOND);
    	//CRUSHER(5, 3, 100, 8.0F, 3.0F, 10, Items.APPLE);
    	
        private final int miningSize;
        private final int harvestLevel;
        private final int maxUses;
        private final float efficiency;
        private final float attackDamage;
        private final int enchantability;
        private final Item repairMaterial;
       
        private DrillTier(int miningSize, int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Item repairMaterial)
        {
            this.miningSize = miningSize;
            this.harvestLevel = harvestLevel;
            this.maxUses = maxUses;
            this.efficiency = efficiency;
            this.attackDamage = attackDamage;
            this.enchantability = enchantability;
            this.repairMaterial = repairMaterial;
        }
       
        public int getMiningSize()
        {
            return this.miningSize;
        }
 
        @Override
        public int getMaxUses()
        {
            return this.maxUses;
        }
 
        @Override
        public float getEfficiency()
        {
            return this.efficiency;
        }
 
        @Override
        public float getAttackDamage()
        {
            return this.attackDamage;
        }
 
        @Override
        public int getHarvestLevel()
        {
            return this.harvestLevel;
        }
 
        @Override
        public int getEnchantability()
        {
            return this.enchantability;
        }
 
        @Override
        public Ingredient getRepairMaterial()
        {
            return Ingredient.fromItems(repairMaterial);
        }
    }
    
    
}