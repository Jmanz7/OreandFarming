package io.github.jmanz7.oreandfarming.item;

import io.github.jmanz7.oreandfarming.util.Helper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DrillItem extends PickaxeItem
{
    private final DrillTier tier;

    public DrillItem(DrillTier tier, Properties builder)
    {
        super(tier, 1, -2.8F, builder);
        this.tier = tier;
    }

    @Override
    public DrillTier getTier()
    {
        return tier;
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
            if (this.getTier() == DrillTier.GOLD) this.mineBlock(worldIn, pos.add(0, -1, 0), stack);
            else
            {
                Direction.Axis axis = Helper.getFacing(entityLiving).getAxis();

                int side = this.getTier().getMiningSize() / 2;
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

                        this.mineBlock(worldIn, destroyPos, stack);
                    }
                }
            }

            stack.damageItem(1, entityLiving, (entity) -> entity.sendBreakAnimation(Hand.MAIN_HAND));
        }

        return true;
    }

    private boolean mineBlock(World world, BlockPos pos, ItemStack stack)
    {
        if (world.isRemote) return true;

        BlockState state = world.getBlockState(pos);
        if (state.getBlockHardness(world, pos) >= 0 && this.getTier().getHarvestLevel() >= state.getHarvestLevel())
        {
            if (EnchantmentHelper.getEnchantments(stack).containsKey(Enchantments.SILK_TOUCH))
            {
                Block.spawnAsEntity(world, pos, new ItemStack(state.getBlock().asItem()));
                return world.destroyBlock(pos, false);
            }
            return world.destroyBlock(pos, true);
        }

        return false;
    }

    public enum DrillTier implements IItemTier
    {
        IRON(3, 2, 88, 6.0F, 2.0F, 14, Items.IRON_INGOT),
        GOLD(0, 0, 38, 12.0F, 0.0F, 22, Items.GOLD_INGOT),
        DIAMOND(5, 3, 88, 8.0F, 3.0F, 10, Items.DIAMOND);

        private final int miningSize;
        private final int harvestLevel;
        private final int maxUses;
        private final float efficiency;
        private final float attackDamage;
        private final int enchantability;
        private final Item repairMaterial;

        DrillTier(int miningSize, int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Item repairMaterial)
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
