package jmanz7.oreandfarming.init;





import jmanz7.oreandfarming.OreandFarmingMain;
import jmanz7.oreandfarming.objects.items.DrillItem;
import jmanz7.oreandfarming.objects.items.DrillItem.DrillTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = OreandFarmingMain.MOD_ID, bus = Bus.MOD )
@ObjectHolder(OreandFarmingMain.MOD_ID)
public class ItemInit 
{
	 public static final Item green_apple = null;
	 
	 public static final Item drill_iron = null;
	 
	 @SubscribeEvent
	 public static void registerItems(final RegistryEvent.Register<Item> event)
	 {
		 event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.FOOD)).setRegistryName("green_apple"));
		 
		 event.getRegistry().register(new DrillItem(DrillTier.IRON, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("iron_drill"));
		 event.getRegistry().register(new DrillItem(DrillTier.DIAMOND, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("diamond_drill"));
	 }	
}
