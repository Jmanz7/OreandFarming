package io.github.jmanz7.oreandfarming.init;


import io.github.jmanz7.oreandfarming.OreandFarming;
import io.github.jmanz7.oreandfarming.item.DrillItem;
import io.github.jmanz7.oreandfarming.item.HeatedIronIngotItem;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@SuppressWarnings("unused")
public final class ModItems
{
    public static final DeferredRegister<Item> ITEMS =  new DeferredRegister<>(ForgeRegistries.ITEMS, OreandFarming.MODID);

    public static final RegistryObject<Item> HEATED_IRON_INGOT = ITEMS.register("heated_iron_ingot", () -> new HeatedIronIngotItem(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot", () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> STEEL_BLOCK = ITEMS.register(ModBlocks.STEEL_BLOCK.getId().getPath(), () -> new BlockItem(ModBlocks.STEEL_BLOCK.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
    public static final RegistryObject<Item> COMPRESSED_DIAMOND = ITEMS.register("compressed_diamond", () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> IRON_DRILL = ITEMS.register("iron_drill", () -> new DrillItem(DrillItem.DrillTier.IRON, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> DIAMOND_DRILL = ITEMS.register("diamond_drill", () -> new DrillItem(DrillItem.DrillTier.DIAMOND, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> GOLDEN_DRILL = ITEMS.register("golden_drill", () -> new DrillItem(DrillItem.DrillTier.GOLD, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> IRON_DRILL_HEAD = ITEMS.register("iron_drill_head", () -> new Item(new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> DIAMOND_DRILL_HEAD = ITEMS.register("diamond_drill_head", () -> new Item(new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> GOLDEN_DRILL_HEAD = ITEMS.register("golden_drill_head", () -> new Item(new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> DRILL_BODY = ITEMS.register("drill_body", () -> new Item(new Item.Properties().group(ItemGroup.TOOLS)));


    public static final RegistryObject<Item> GREEN_APPLE = ITEMS.register("green_apple", () -> new Item(new Item.Properties().group(ItemGroup.FOOD).food(Foods.APPLE)));
    public static final RegistryObject<Item> POISONOUS_APPLE = ITEMS.register("poisonous_apple", () -> new Item(new Item.Properties().group(ItemGroup.FOOD).food(ModFoods.POISONOUS_APPLE)));
    public static final RegistryObject<Item> DIAMOND_APPLE = ITEMS.register("diamond_apple", () -> new Item(new Item.Properties().group(ItemGroup.FOOD).rarity(Rarity.RARE).food(ModFoods.DIAMOND_APPLE)));
    public static final RegistryObject<Item> ENCHANTED_DIAMOND_APPLE = ITEMS.register("enchanted_diamond_apple", () -> new EnchantedGoldenAppleItem(new Item.Properties().group(ItemGroup.FOOD).rarity(Rarity.EPIC).food(ModFoods.ENCHANTED_DIAMOND_APPLE)));
    public static final RegistryObject<Item> STEEL_APPLE = ITEMS.register("steel_apple", () -> new Item(new Item.Properties().group(ItemGroup.FOOD).rarity(Rarity.RARE).food(ModFoods.STEEL_APPLE)));
    // public static final RegistryObject<Item> COMPRESSOR = ITEMS.register(ModBlocks.COMPRESSOR.getId().getPath(), () -> new BlockItem(ModBlocks.COMPRESSOR.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
}
