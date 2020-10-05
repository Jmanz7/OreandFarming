package io.github.jmanz7.oreandfarming.init;

import io.github.jmanz7.oreandfarming.OreandFarming;
import io.github.jmanz7.oreandfarming.loot.AppleConverterModifier;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@SuppressWarnings("unused")
public final class ModLootModifierSerializers
{
    public static final DeferredRegister<GlobalLootModifierSerializer<?>> LOOT_MODIFIER_SERIALIZERS = DeferredRegister.create(ForgeRegistries.LOOT_MODIFIER_SERIALIZERS, OreandFarming.MODID);

    public static final RegistryObject<GlobalLootModifierSerializer<AppleConverterModifier>> APPLE_CONVERTER = LOOT_MODIFIER_SERIALIZERS.register("apple_converter", AppleConverterModifier.Serializer::new);
}
