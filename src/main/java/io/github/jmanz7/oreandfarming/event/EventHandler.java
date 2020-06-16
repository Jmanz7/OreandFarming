package io.github.jmanz7.oreandfarming.event;

import net.minecraft.block.*;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber
public class EventHandler
{
	@SubscribeEvent
	public static void dropExpFromCrops(BreakEvent event)
	{
		Block block = event.getState().getBlock();

		if ((block instanceof CropsBlock && ((CropsBlock)block).isMaxAge(event.getState()))
		 || (block instanceof NetherWartBlock && event.getState().get(NetherWartBlock.AGE) == 3)
		 || (block instanceof MelonBlock))
			event.setExpToDrop(1);
	}

	@SubscribeEvent
	public static void dropExpFromSweetBerryBushes(PlayerInteractEvent.RightClickBlock event)
	{
		World world = event.getWorld();
		BlockPos pos = event.getPos();
		BlockState state = world.getBlockState(pos);

		if (!world.isRemote && !event.getPlayer().abilities.isCreativeMode && state.getBlock() instanceof SweetBerryBushBlock && state.get(SweetBerryBushBlock.AGE) == 3)
			world.addEntity(new ExperienceOrbEntity(world, (double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, 1));
	}
}
