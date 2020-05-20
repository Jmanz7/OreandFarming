package io.github.jmanz7.oreandfarming.init;


import io.github.jmanz7.oreandfarming.OreandFarming;
import io.github.jmanz7.oreandfarming.item.DrillItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@SuppressWarnings("unused")
public class ItemInit
{
    public static final DeferredRegister<Item> ITEMS =  new DeferredRegister<>(ForgeRegistries.ITEMS, OreandFarming.MODID);

    // Items
    public static final RegistryObject<Item> HEATED_IRON_INGOT = ITEMS.register("heated_iron_ingot", () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot", () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> STEEL_BLOCK = ITEMS.register(BlockInit.STEEL_BLOCK.getId().getPath(), () -> new BlockItem(BlockInit.STEEL_BLOCK.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
    public static final RegistryObject<Item> IRON_DRILL = ITEMS.register("iron_drill", () -> new DrillItem(DrillItem.DrillTier.IRON, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> DIAMOND_DRILL = ITEMS.register("diamond_drill", () -> new DrillItem(DrillItem.DrillTier.DIAMOND, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> GOLDEN_DRILL = ITEMS.register("golden_drill", () -> new DrillItem(DrillItem.DrillTier.GOLD, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> IRON_DRILL_HEAD = ITEMS.register("iron_drill_head", () -> new Item(new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> DIAMOND_DRILL_HEAD = ITEMS.register("diamond_drill_head", () -> new Item(new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> GOLDEN_DRILL_HEAD = ITEMS.register("golden_drill_head", () -> new Item(new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> DRILL_BODY = ITEMS.register("drill_body", () -> new Item(new Item.Properties().group(ItemGroup.TOOLS)));
}
