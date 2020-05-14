package io.github.jmanz7.oreandfarming;


import io.github.jmanz7.oreandfarming.init.BlockInit;
import io.github.jmanz7.oreandfarming.init.ItemInit;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;



@Mod("oreandfarming")
public class OreandFarming
{
    //private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID= "oreandfarming";
    public static OreandFarming instance;
    IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();


    public OreandFarming() 
    {
    	
    	instance = this;

       // FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
      // FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        ItemInit.ITEMS.register(modEventBus);
        BlockInit.BLOCKS.register(modEventBus);
        
        MinecraftForge.EVENT_BUS.register(this);
        
        
    }

   // private void setup(final FMLCommonSetupEvent event) { }

   // private void doClientStuff(final FMLClientSetupEvent event) { }
    
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) 
    {
        
    }
}
