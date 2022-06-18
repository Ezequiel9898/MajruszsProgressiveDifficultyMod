package com.majruszsdifficulty.entities;

import com.majruszsdifficulty.Registries;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.level.Level;

import java.util.function.Supplier;

/** Entity that is smaller version of Creeper. */
public class CreeperlingEntity extends Creeper {
	public static Supplier< EntityType< CreeperlingEntity > > createSupplier() {
		return () -> EntityType.Builder.of( CreeperlingEntity::new, MobCategory.MONSTER ).sized( 0.6f, 0.9f ).build("creeperling" );
	}

	public CreeperlingEntity( EntityType< ? extends CreeperlingEntity > type, Level world ) {
		super( type, world );
		this.explosionRadius = 2;
		this.xpReward = 3;
	}

	@Override
	public boolean isPowered() {
		return false; // creeperling can not be charged
	}

	@Override
	protected float getStandingEyeHeight( Pose poseIn, EntityDimensions sizeIn ) {
		return 0.75f;
	}

	public static AttributeSupplier getAttributeMap() {
		return Mob.createMobAttributes().add( Attributes.MAX_HEALTH, 6.0 ).add( Attributes.MOVEMENT_SPEED, 0.35 ).build();
	}
}
