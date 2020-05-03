package io.github.jmanz7.oreandfarming;


import net.minecraftforge.common.MinecraftForge;
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
   
    public OreandFarming() 
    {
    	
    	instance = this;
    	
    	
    	//ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.server_config);
       // ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.client_config);
        
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

       // Config.loadConfig(Config.client_config, FMLPaths.CONFIGDIR.get().resolve("oreandfarming-client.toml").toString());
        //Config.loadConfig(Config.server_config, FMLPaths.CONFIGDIR.get().resolve("oreandfarming-server.toml").toString());
        
        MinecraftForge.EVENT_BUS.register(this);
        
        
    }

    private void setup(final FMLCommonSetupEvent event)
    {
    	
    }

    private void doClientStuff(final FMLClientSetupEvent event) 
    {
        
    }
    
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) 
    {
        
    }
}
