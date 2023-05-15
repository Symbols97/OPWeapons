package com.Symbols97.OPWeapons.capabilities;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class isWearingOPWArmor implements INBTSerializable<CompoundTag> {

	private boolean isWearingOPArmor = false;
	String oparmor = "isWearingOPArmor";
	private int repairTickOPArmor = 0;
	String reapirtickOPArmor = "repairTickOPArmor";

	
	private boolean isWearingLostArmor = false;
	String lostarmor = "isWearingLostArmor";
	
	private boolean isWearingDemonArmor = false;
	String demonarmor = "isWearingDemonArmor";
	private int repairTickDemonArmor = 0;
	String repairtickDemonArmor = "repairtickDemonArmor";
	
	private boolean isWearingFrostArmor = false;
	String frostarmor = "isWearingFrostArmor";
	private int repairTickFrostArmor = 0;
	String repairtickFrostArmor = "repairtickFrostArmor";
	
	private boolean isWearingReaperArmor = false;
	String reaperarmor = "isWearingReaperArmor";
	private int repairTickReaperArmor = 0;
	String repairtickReaperArmor = "repairtickReaperArmor";
	
	public CompoundTag serializeNBT() {
		CompoundTag nbt = new CompoundTag();
		nbt.putBoolean(oparmor, this.isWearingOPArmor());
		nbt.putInt(reapirtickOPArmor, repairTickOPArmor);
		nbt.putBoolean(demonarmor, this.isWearingDemonArmor());
		nbt.putBoolean(lostarmor, this.isWearingLostArmor());
		nbt.putInt(repairtickDemonArmor, repairTickDemonArmor);
		nbt.putBoolean(frostarmor, this.isWearingFrostArmor());
		nbt.putInt(repairtickFrostArmor, repairTickFrostArmor);
		nbt.putBoolean(reaperarmor, this.isWearingReaperArmor());
		nbt.putInt(repairtickReaperArmor, repairTickReaperArmor);
		return nbt;
	}

	public void deserializeNBT(CompoundTag nbtTag) {
		this.setWearingOPArmor(nbtTag.getBoolean(oparmor));
		this.setRepairTickOPArmor(nbtTag.getInt(reapirtickOPArmor));
		this.setWearingDemonArmor(nbtTag.getBoolean(demonarmor));
		this.setWearingLostArmor(nbtTag.getBoolean(lostarmor));
		this.setRepairTickDemonArmor(nbtTag.getInt(repairtickDemonArmor));
		this.setWearingFrostArmor(nbtTag.getBoolean(frostarmor));
		this.setRepairTickFrostArmor(nbtTag.getInt(repairtickFrostArmor));
		this.setWearingLostArmor(nbtTag.getBoolean(reaperarmor));
		this.setRepairTickReaperArmor(nbtTag.getInt(repairtickReaperArmor));
		
	}

	
       public static void resetValueOnRespawn(PlayerEvent.Clone event) {
           if (event.getEntity() instanceof ServerPlayer serverPlayerNew && event.getOriginal() instanceof ServerPlayer serverPlayerOld) {
               if (event.isWasDeath()) {
                   serverPlayerOld.reviveCaps();
    
                   serverPlayerOld.invalidateCaps();
               }
           }
       }

	public boolean isWearingOPArmor() {
		return isWearingOPArmor;
	}

	public void setWearingOPArmor(boolean isWearingOPArmor) {
		this.isWearingOPArmor = isWearingOPArmor;
	}

	public boolean isWearingDemonArmor() {
		return isWearingDemonArmor;
	}

	public void setWearingDemonArmor(boolean isWearingDemonArmor) {
		this.isWearingDemonArmor = isWearingDemonArmor;
	}

	public int getRepairTickOPArmor() {
		return repairTickOPArmor;
	}

	public void setRepairTickOPArmor(int repairTickOPArmor) {
		this.repairTickOPArmor = repairTickOPArmor;
	}

	public boolean isWearingLostArmor() {
		return isWearingLostArmor;
	}

	public void setWearingLostArmor(boolean isWearingLostArmor) {
		this.isWearingLostArmor = isWearingLostArmor;
	}

	public int getRepairTickDemonArmor() {
		return repairTickDemonArmor;
	}

	public void setRepairTickDemonArmor(int repairTickDemonArmor) {
		this.repairTickDemonArmor = repairTickDemonArmor;
	}

	public boolean isWearingFrostArmor() {
		return isWearingFrostArmor;
	}

	public void setWearingFrostArmor(boolean isWearingFrostArmor) {
		this.isWearingFrostArmor = isWearingFrostArmor;
	}

	public int getRepairTickFrostArmor() {
		return repairTickFrostArmor;
	}

	public void setRepairTickFrostArmor(int repairTickFrostArmor) {
		this.repairTickFrostArmor = repairTickFrostArmor;
	}

	public boolean isWearingReaperArmor() {
		return isWearingReaperArmor;
	}

	public void setWearingReaperArmor(boolean isWearingReaperArmor) {
		this.isWearingReaperArmor = isWearingReaperArmor;
	}

	public int getRepairTickReaperArmor() {
		return repairTickReaperArmor;
	}

	public void setRepairTickReaperArmor(int repairTickReaperArmor) {
		this.repairTickReaperArmor = repairTickReaperArmor;
	}


	
}

