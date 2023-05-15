package com.Symbols97.OPWeapons.Dimension.DeadZone;

import java.util.List;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;

public class DeadZoneChunkProvider implements IChunkProvider {

	public boolean chunkExists(int p_73149_1_, int p_73149_2_) {
		 
		return false;
	}

	public Chunk provideChunk(int p_73154_1_, int p_73154_2_) {
		 
		return null;
	}

	public Chunk loadChunk(int p_73158_1_, int p_73158_2_) {
		 
		return null;
	}

	public void populate(IChunkProvider p_73153_1_, int p_73153_2_, int p_73153_3_) {
		 

	}

	public boolean saveChunks(boolean p_73151_1_, IProgressUpdate p_73151_2_) {
		 
		return false;
	}

	public boolean unloadQueuedChunks() {
		 
		return false;
	}

	public boolean canSave() {
		 
		return false;
	}

	public String makeString() {
		 
		return null;
	}

	public List getPossibleCreatures(EnumCreatureType p_73155_1_, int p_73155_2_, int p_73155_3_, int p_73155_4_) {
		 
		return null;
	}

	public ChunkPosition func_147416_a(World p_147416_1_, String p_147416_2_, int p_147416_3_, int p_147416_4_,
			int p_147416_5_) {
		 
		return null;
	}

	public int getLoadedChunkCount() {
		 
		return 0;
	}

	public void recreateStructures(int p_82695_1_, int p_82695_2_) {
		 

	}

	public void saveExtraData() {
		 

	}

}
