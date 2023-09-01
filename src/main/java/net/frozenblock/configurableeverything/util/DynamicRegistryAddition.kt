package net.frozenblock.configurableverything.util

import net.fabricmc.fabric.api.event.registry.DynamicRegistries
import net.minecraft.core.Registry
import net.minecraft.resources.ResourceKey

data class DynamicRegistryAddition<T>(registry: ResourceKey<out Registry<T>>, key: ResourceKey<T>, value: T) {
    companion object {
        @JvmStatic
        fun <T> codec(registry: ResourceKey<out Registry<T>>, valueCodec: Codec<T>): Codec<DynamicRegistryAddition<T>> {
            return RecordCodecBuilder.create { instance ->
                instance.group(
                    ResourceKey.codec(Registries.REGISTRY).fieldOf("registry").forGetter(DynamicRegistryAddition::registry),
                    ResourceKey.codec(registry).fieldOf("key").forGetter(DynamicRegistryAddition::key),
                    valueCodec.fieldOf("value").forGetter(DynamicRegistryAddition::value)
                )
            }
        }
    }

    fun register() {
        TODO()
    }
}