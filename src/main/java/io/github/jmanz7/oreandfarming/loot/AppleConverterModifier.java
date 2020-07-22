package io.github.jmanz7.oreandfarming.loot;

import com.google.gson.JsonObject;
import io.github.jmanz7.oreandfarming.OreandFarming;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.conditions.ILootCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.List;

public class AppleConverterModifier extends LootModifier
{
    private final float chanceToConvert;
    private final Item itemToCheck;
    private final Item replacementItem;

    /**
     * Constructs a LootModifier.
     *
     * @param conditionsIn the ILootConditions that need to be matched before the loot is modified.
     */
    protected AppleConverterModifier(ILootCondition[] conditionsIn, float chance, Item itemToCheck, Item replacementItem)
    {
        super(conditionsIn);
        chanceToConvert = chance;
        this.itemToCheck = itemToCheck;
        this.replacementItem = replacementItem;
    }

    @Nonnull
    @Override
    protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context)
    {
        for (ItemStack stack : generatedLoot)
        {
            if (stack.getItem() == itemToCheck && context.getRandom().nextFloat() < chanceToConvert)
            {
                generatedLoot.remove(stack);
                generatedLoot.add(new ItemStack(replacementItem));
            }
        }

        return generatedLoot;
    }

    public static class Serializer extends GlobalLootModifierSerializer<AppleConverterModifier>
    {
        @Override
        public AppleConverterModifier read(ResourceLocation location, JsonObject object, ILootCondition[] conditions)
        {
            float chance = JSONUtils.getFloat(object, "chance");
            Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(JSONUtils.getString(object, "item")));
            Item replacement = ForgeRegistries.ITEMS.getValue(new ResourceLocation(JSONUtils.getString(object, "replacement")));
            return new AppleConverterModifier(conditions, chance, item, replacement);
        }
    }
}
