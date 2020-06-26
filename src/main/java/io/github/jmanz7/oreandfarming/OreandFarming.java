package io.github.jmanz7.oreandfarming;

import io.github.jmanz7.oreandfarming.init.ModBlocks;
import io.github.jmanz7.oreandfarming.init.ModItems;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(OreandFarming.MODID)
public class OreandFarming
{
    public static final String MODID = "oreandfarming";
    // public static final Logger LOGGER = LogManager.getLogger(MODID);

    public static final DamageSource HEATED_IRON_INGOT = new DamageSource("heated_iron_ingot");

    public OreandFarming()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        
        MinecraftForge.EVENT_BUS.register(this);
    }
}
