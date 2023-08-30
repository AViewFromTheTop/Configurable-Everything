package net.frozenblock.configurableeverything.entity.util

import com.mojang.serialization.Codec
import com.mojang.serialization.codecs.RecordCodecBuilder
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.world.entity.EntityType

data class EntityHurtEffects(
    @JvmField var entity: ResourceKey<EntityType<*>>,
    @JvmField var entityName: String,
    @JvmField var effects: List<MobEffectHolder>
) {
    companion object {
        @JvmField
        val CODEC: Codec<EntityHurtEffects> = RecordCodecBuilder.create { instance ->
            instance.group(
                ResourceKey.codec(Registries.ENTITY_TYPE).fieldOf("entity").forGetter(EntityHurtEffects::entity),
                Codec.STRING.fieldOf("entityName").forGetter(EntityHurtEffects::entityName),
                MobEffectHolder.CODEC.listOf().fieldOf("effects").forGetter(EntityHurtEffects::effects)
            ).apply(instance, ::EntityHurtEffects)
        }
    }
}
