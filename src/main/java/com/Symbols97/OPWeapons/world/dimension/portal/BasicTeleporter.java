package com.Symbols97.OPWeapons.world.dimension.portal;



import java.util.function.Function;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.common.util.ITeleporter;

public class BasicTeleporter implements ITeleporter{

	protected final ServerLevel level;

    public BasicTeleporter(ServerLevel worldIn) {
        this.level = worldIn;
    }
    @Override
    public Entity placeEntity(Entity player, ServerLevel currentWorld, ServerLevel destWorld, float yaw, Function<Boolean, Entity> repositionEntity)
    {
    	
        return repositionEntity.apply(false);
    }
	
}
