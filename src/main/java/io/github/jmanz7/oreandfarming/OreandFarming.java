package io.github.jmanz7.oreandfarming;

import io.github.jmanz7.oreandfarming.init.BlockInit;
import io.github.jmanz7.oreandfarming.init.ItemInit;
import net.minecraft.block.SugarCaneBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(OreandFarming.MODID)
public class OreandFarming
{
    public static final String MODID = "oreandfarming";

    public OreandFarming() 
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemInit.ITEMS.register(modEventBus);
        BlockInit.BLOCKS.register(modEventBus);
        
        MinecraftForge.EVENT_BUS.register(this);
    }
}
