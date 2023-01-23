package com.majruszsdifficulty.commands;

import com.majruszsdifficulty.treasurebags.LootProgressManager;
import com.mlib.Utility;
import com.mlib.annotations.AutoInstance;
import com.mlib.commands.CommandData;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.network.chat.*;
import net.minecraft.world.entity.player.Player;

@AutoInstance
public class TreasureBagResetProgressCommand extends DifficultyCommand {
	public TreasureBagResetProgressCommand() {
		this.newBuilder()
			.literal( "treasurebag" )
			.literal( "reset" )
			.hasPermission( 4 )
			.execute( this::handle )
			.entity()
			.execute( this::handle );

	}

	private int handle( CommandData data ) throws CommandSyntaxException {
		Player player = Utility.castIfPossible( Player.class, this.getOptionalEntityOrPlayer( data ) );
		if( player != null ) {
			LootProgressManager.cleanProgress( player );
			data.source.sendSuccess( new TranslatableComponent( "commands.treasurebag.reset", player.getName() ), true );
			return 0;
		}

		return -1;
	}
}
