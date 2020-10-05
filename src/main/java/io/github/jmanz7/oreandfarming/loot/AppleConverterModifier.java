package io.github.jmanz7.oreandfarming.loot;

import com.google.gson.JsonObject;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameters;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.WeightedRandom;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AppleConverterModifier extends LootModifier
{
    private final int weightForKeeping, replacementWeight, specialReplacementWeight;
    private final Item itemToReplace, replacementItem, specialReplacementItem;

    /**
     * Constructs a LootModifier.
     *
     * @param conditionsIn the ILootConditions that need to be matched before the loot is modified.
     */
    protected AppleConverterModifier(ILootCondition[] conditionsIn, Item itemToReplace, int weightForKeeping, Item replacementItem, int replacementWeight, Item specialReplacementItem, int specialReplacementWeight)
    {
        super(conditionsIn);
        this.weightForKeeping = weightForKeeping;
        this.replacementWeight = replacementWeight;
        this.specialReplacementWeight = specialReplacementWeight;
        this.itemToReplace = itemToReplace;
        this.replacementItem = replacementItem;
        this.specialReplacementItem = specialReplacementItem;
    }

    @Nonnull
    @Override
    protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context)
    {
        generatedLoot.replaceAll(stack -> replaceOrKeep(stack, context.getRandom(), context.get(LootParameters.BLOCK_ENTITY) == null));
        return generatedLoot;
    }

    private ItemStack replaceOrKeep(ItemStack stackToReplaceItem, Random random, boolean allowSpecialReplacement)
    {
        List<WeightedRandom.Item> options = new ArrayList<>();

        options.add(new WeightedRandom.Item(weightForKeeping));
        options.add(new WeightedRandom.Item(replacementWeight));
        if (allowSpecialReplacement)
            options.add(new WeightedRandom.Item(specialReplacementWeight));

        WeightedRandom.Item result = WeightedRandom.getRandomItem(random, options);
        if (result == options.get(1))
            return copySetItem(stackToReplaceItem, replacementItem);
        if (result == options.get(2))
            return copySetItem(stackToReplaceItem, specialReplacementItem);
        else return new ItemStack(itemToReplace);
    }

    private ItemStack copySetItem(ItemStack stack, Item item)
    {
        ItemStack newStack = new ItemStack(item, stack.getCount());
        newStack.setTag(stack.getTag());
        return newStack;
    }

    public static class Serializer extends GlobalLootModifierSerializer<AppleConverterModifier>
    {
        @Override
        public AppleConverterModifier read(ResourceLocation location, JsonObject object, ILootCondition[] conditions)
        {
            Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(JSONUtils.getString(object, "item")));
            int weightForKeeping = JSONUtils.getInt(object, "weightForKeeping");
            Item replacement = ForgeRegistries.ITEMS.getValue(new ResourceLocation(JSONUtils.getString(object, "replacement")));
            int replacementWeight = JSONUtils.getInt(object, "replacementWeight");
            Item specialReplacement = ForgeRegistries.ITEMS.getValue(new ResourceLocation(JSONUtils.getString(object, "specialReplacement")));
            int specialReplacementWeight = JSONUtils.getInt(object, "specialReplacementWeight");

            return new AppleConverterModifier(conditions, item, weightForKeeping, replacement, replacementWeight, specialReplacement, specialReplacementWeight);
        }

        @Override
        public JsonObject write(AppleConverterModifier instance) {
            return null;
        }
    }
}
