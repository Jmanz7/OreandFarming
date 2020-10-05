package io.github.jmanz7.oreandfarming.init;

import io.github.jmanz7.oreandfarming.OreandFarming;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class ModBlocks
{
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, OreandFarming.MODID);

    public static final RegistryObject<Block> STEEL_BLOCK = BLOCKS.register("steel_block", () -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
    // public static final RegistryObject<Block> COMPRESSOR = BLOCKS.register("compressor", () -> new CompressorBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(3.5F).sound(SoundType.METAL)));
}
