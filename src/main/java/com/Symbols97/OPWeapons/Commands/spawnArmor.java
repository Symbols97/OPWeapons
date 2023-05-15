package com.Symbols97.OPWeapons.Commands;

import java.util.ArrayList;
import java.util.List;

import com.Symbols97.OPWeapons.OPWeapons;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class spawnArmor extends CommandBase {
	
	
    private final List aliases; 
    private final List armorTypes; 
    public spawnArmor() 
    { 
        aliases = new ArrayList();  
        aliases.add("spawnarmor");
        aliases.add("SpawnArmor");
  
        armorTypes = new ArrayList();
        armorTypes.add("OP");
        armorTypes.add("Demon");
        armorTypes.add("Frost");
        armorTypes.add("Lost");
        armorTypes.add("Reaper");
        

    } 
  
    @Override 
    public int compareTo(Object o)
    { 
        return 0; 
    } 

    @Override 
    public String getCommandName() 
    { 
        return "spawnarmor"; 
    } 

    @Override         
    public String getCommandUsage(ICommandSender var1) 
    { 
        return String.format("§aOPWeapons: §7/SpawnArmor <§aOP§7/§cDemon§7/§bFrost§7/§7Lost/§8Reaper§7>"); 
        
    } 

    @Override 
    public List getCommandAliases() 
    { 
        return this.aliases;
    } 
    
    
    public void processCommand(ICommandSender sender, String[] argString)
    { 
    	World world = sender.getEntityWorld();
        EntityPlayer player = (EntityPlayer)sender;
        if (argString.length > 0) {
          String func = argString[0];
          if (func.equals("OP") || func.equals("op") ) {
            if (argString.length == 1) {   	
            	if (player.getCurrentArmor(3) == null && player.getCurrentArmor(2) == null && player.getCurrentArmor(1) == null && player.getCurrentArmor(0) == null){
            	player.setCurrentItemOrArmor(4, new ItemStack(OPWeapons.opHelmet));
     			player.setCurrentItemOrArmor(3, new ItemStack(OPWeapons.opChestplate));
     			player.setCurrentItemOrArmor(2, new ItemStack(OPWeapons.opLeggings));
     			player.setCurrentItemOrArmor(1, new ItemStack(OPWeapons.opBoots));
            	} else {
            		player.addChatMessage(new ChatComponentText(String.format("§cMust not being wearing armor to perform this command.")));
            	}    			
            } else {
            	player.addChatMessage(new ChatComponentText(String.format("/SpawnArmor §aOP")));
            } 
          } else if (func.equals("Demon") || func.equals("demon")) {
            if (argString.length == 1) {        	
            	if (player.getCurrentArmor(3) == null && player.getCurrentArmor(2) == null && player.getCurrentArmor(1) == null && player.getCurrentArmor(0) == null){
            	player.setCurrentItemOrArmor(4, new ItemStack(OPWeapons.demonHead));
     			player.setCurrentItemOrArmor(3, new ItemStack(OPWeapons.demonChest));
     			player.setCurrentItemOrArmor(2, new ItemStack(OPWeapons.demonLeggings));
     			player.setCurrentItemOrArmor(1, new ItemStack(OPWeapons.demonBoots));
            	} else {
            		player.addChatMessage(new ChatComponentText(String.format("§cMust not being wearing armor to perform this command.")));
            	}	
            } else {
            	player.addChatMessage(new ChatComponentText(String.format("/SpawnArmor §cDemon")));
            } 
          } else if (func.equals("Frost") || func.equals("frost")) {
            if (argString.length == 1) {
            	
            	if (player.getCurrentArmor(3) == null && player.getCurrentArmor(2) == null && player.getCurrentArmor(1) == null && player.getCurrentArmor(0) == null){
            	player.setCurrentItemOrArmor(4, new ItemStack(OPWeapons.frostHelmet));
     			player.setCurrentItemOrArmor(3, new ItemStack(OPWeapons.frostChestplate));
     			player.setCurrentItemOrArmor(2, new ItemStack(OPWeapons.frostLeggings));
     			player.setCurrentItemOrArmor(1, new ItemStack(OPWeapons.frostBoots));
            	} else {
            		player.addChatMessage(new ChatComponentText(String.format("§cMust not being wearing armor to perform this command.")));
            	}
            } else {
            	player.addChatMessage(new ChatComponentText(String.format("/SpawnArmor §bFrost")));
            }
          
          } else if (func.equals("Lost") || func.equals("lost")) {
            if (argString.length == 1) {
            	if (player.getCurrentArmor(3) == null && player.getCurrentArmor(2) == null && player.getCurrentArmor(1) == null && player.getCurrentArmor(0) == null){
            	player.setCurrentItemOrArmor(4, new ItemStack(OPWeapons.lostHelmet));
     			player.setCurrentItemOrArmor(3, new ItemStack(OPWeapons.lostChestplate));
     			player.setCurrentItemOrArmor(2, new ItemStack(OPWeapons.lostLeggings));
     			player.setCurrentItemOrArmor(1, new ItemStack(OPWeapons.lostBoots));
            	} else {
            		player.addChatMessage(new ChatComponentText(String.format("§cMust not being wearing armor to perform this command.")));
            	}
            } else {
            	player.addChatMessage(new ChatComponentText(String.format("/SpawnArmor §7Lost")));
            }  
        } else if (func.equals("Reaper") || func.equals("reaper")) {
            if (argString.length == 1) {
            	
            	if (player.getCurrentArmor(3) == null && player.getCurrentArmor(2) == null && player.getCurrentArmor(1) == null && player.getCurrentArmor(0) == null){
            	player.setCurrentItemOrArmor(4, new ItemStack(OPWeapons.reaperHead));
     			player.setCurrentItemOrArmor(3, new ItemStack(OPWeapons.reaperChest));
     			player.setCurrentItemOrArmor(2, new ItemStack(OPWeapons.reaperLeggings));
     			player.setCurrentItemOrArmor(1, new ItemStack(OPWeapons.reaperBoots));
     			player.inventory.addItemStackToInventory(new ItemStack(OPWeapons.soulHarvester));
            	} else {
            		player.addChatMessage(new ChatComponentText(String.format("§cMust not being wearing armor to perform this command.")));
            	}
            } else {
            	player.addChatMessage(new ChatComponentText(String.format("/SpawnArmor §8Reaper")));
            }
          
          } else {
        	player.addChatMessage(new ChatComponentText(String.format("§7/SpawnArmor <§aOP§7/§cDemon§7/§bFrost§7/§7Lost/§8Reaper§7>")));
        } 
    } else {
    	player.addChatMessage(new ChatComponentText(String.format("§7/SpawnArmor <§aOP§7/§cDemon§7/§bFrost§7/§7Lost/§8Reaper§7>")));
    }
}
      

    @Override 
    public boolean canCommandSenderUseCommand(ICommandSender sender) 
    { 
    	EntityPlayer player = (EntityPlayer) sender;
    	return player.canCommandSenderUseCommand(4, getCommandName());
    	
    } 

    @Override  
    public List addTabCompletionOptions(ICommandSender var1, String[] var2) 
    { 
        // TODO Auto-generated method stub 
        return armorTypes; 
    } 

    @Override 
    public boolean isUsernameIndex(String[] var1, int var2) 
    { 
        // TODO Auto-generated method stub 
        return false;
    }

	
}