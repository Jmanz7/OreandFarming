package jmanz7.oreandfarming.event;

import net.minecraft.block.Block;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.NetherWartBlock;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class DropXP 
{
	@SubscribeEvent
	public static void dropExpFormCrops(BreakEvent event)
	{
		Block crop = event.getState().getBlock();
		if(crop instanceof CropsBlock)
		{
			if(((CropsBlock)crop).isMaxAge(event.getState()))
				event.setExpToDrop(1);
		}
		if(crop instanceof NetherWartBlock)
		{
			if(event.getState().get(BlockStateProperties.AGE_0_3) == Integer.valueOf(3))
				event.setExpToDrop(1);
		}
	}
}
