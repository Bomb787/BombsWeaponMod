/*package bwm.core.init;

import java.util.function.BiFunction;

import bwm.WeaponsMod;
import bwm.common.entities.BackblastEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityInit {
	
	public static final DeferredRegister<EntityType<?>> ENTITY_REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITIES, WeaponsMod.MOD_ID);
	
	public static final RegistryObject<EntityType<BackblastEntity>> BACKBLAST = registerBasic("backblast", BackblastEntity::new);
	
	private static <T extends Entity> RegistryObject<EntityType<T>> registerBasic(String id, BiFunction<EntityType<T>, World, T> function) {
        EntityType<T> type = EntityType.Builder.create(function::apply, EntityClassification.MISC)
                .size(0.25F, 0.25F)
                .setTrackingRange(100)
                .setUpdateInterval(1)
                .disableSummoning()
                .immuneToFire()
                .setShouldReceiveVelocityUpdates(true)
                .build(id);
        return ENTITY_REGISTRY.register(id, () -> type);
        
	}

}
*/