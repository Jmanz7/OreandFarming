package io.github.jmanz7.oreandfarming.sound;

import io.github.jmanz7.oreandfarming.OreandFarming;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundList 
{
	public static final DeferredRegister<SoundEvent> SOUNDS = new DeferredRegister<>(ForgeRegistries.SOUND_EVENTS, OreandFarming.MOD_ID);

	public static final Lazy<SoundEvent> MUSIC_DISC_PIGSTEP = Lazy.of(() -> new SoundEvent(new ResourceLocation(OreandFarming.MOD_ID, "item.music_disc_pigstep")));
	
	public static final RegistryObject<SoundEvent> MUSIC_DISC = SOUNDS.register("item.music_disc_pigstep.disc", MUSIC_DISC_PIGSTEP);
	
	
	
}
