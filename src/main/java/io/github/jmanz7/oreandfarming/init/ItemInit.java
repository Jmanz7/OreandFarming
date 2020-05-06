package io.github.jmanz7.oreandfarming.init;





import io.github.jmanz7.oreandfarming.OreandFarming;
import io.github.jmanz7.oreandfarming.items.DrillItem;
import io.github.jmanz7.oreandfarming.items.DrillItem.DrillTier;
import io.github.jmanz7.oreandfarming.items.MusicDiscPigStep;
import io.github.jmanz7.oreandfarming.sound.SoundList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = OreandFarming.MOD_ID, bus = Bus.MOD )
@ObjectHolder(OreandFarming.MOD_ID)
public class ItemInit 
{
	 public static final Item green_apple = null;
	 public static final Item drill_iron = null;
	 public static final Item iron_drill_head = null;
	 public static final Item diamond_drill_head = null;
	 public static final Item drill_body = null;
	 public static final Item steel_ingot= null;
	 public static final Item music_disc_pigstep = null;
	 //public static final Item green_apple = null;
	 
	 //public static final DeferredRegister<Item> ITEMS = new DeferredRegister<Item>(ForgeRegistries.ITEMS, OreandFarming.MOD_ID);
	
	 //public static final RegistryObject<Item> MUSIC_DISC_PIGSTEP = ITEMS.register("music_disc_pigstep", () -> new MusicDiscPigStep(1, SoundList.MUSIC_DISC_PIGSTEP.get(), new Item.Properties().maxStackSize(1).group(ItemGroup.MISC)));
	 
	 @SubscribeEvent
	 public static void registerItems(final RegistryEvent.Register<Item> event)
	 {
		 event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.FOOD)).setRegistryName("green_apple"));
		 
		 event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName("iron_drill_head"));
		 event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName("diamond_drill_head"));
		 event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName("drill_body"));
		 event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName("steel_ingot"));
		 
		 event.getRegistry().register(new MusicDiscPigStep(1, SoundList.MUSIC_DISC_PIGSTEP.get(), new Item.Properties().maxStackSize(1).group(ItemGroup.MISC)).setRegistryName("music_disc_pigstep"));
		 
		 event.getRegistry().register(new DrillItem(DrillTier.IRON, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("iron_drill"));
		 event.getRegistry().register(new DrillItem(DrillTier.DIAMOND, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("diamond_drill"));
	 }	
}
