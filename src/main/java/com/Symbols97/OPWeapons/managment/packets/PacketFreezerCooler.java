package com.Symbols97.OPWeapons.managment.packets;



import com.Symbols97.OPWeapons.TileEntity.TileEntityFreezer;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.tileentity.TileEntity;

public class PacketFreezerCooler implements IMessage, IMessageHandler<PacketFreezerCooler, IMessage> {
	
	
	  private int x;
	  private int y;
	  private int z;

	  private TileEntityFreezer.Mode mode;

	  public PacketFreezerCooler() {

	  }

	  public PacketFreezerCooler(TileEntityFreezer tile) {
	    x = tile.xCoord;
	    y = tile.yCoord;
	    z = tile.zCoord;
	    mode = tile.getMode();
	  }

	  @Override
	  public void toBytes(ByteBuf buf) {
	    buf.writeInt(x);
	    buf.writeInt(y);
	    buf.writeInt(z);
	    buf.writeShort(mode.ordinal());
	  }

	  @Override
	  public void fromBytes(ByteBuf buf) {
	    x = buf.readInt();
	    y = buf.readInt();
	    z = buf.readInt();
	    short ordinal = buf.readShort();
	    mode = TileEntityFreezer.Mode.values()[ordinal];

	  }

	 
	  public IMessage onMessage(PacketFreezerCooler message, MessageContext ctx) {
	    TileEntity te = ctx.getServerHandler().playerEntity.worldObj.getTileEntity(message.x, message.y, message.z);
	    if(te instanceof TileEntityFreezer) {
	      TileEntityFreezer me = (TileEntityFreezer) te;
	      me.setMode(message.mode);
	      ctx.getServerHandler().playerEntity.worldObj.markBlockForUpdate(message.x, message.y, message.z);
	    }
	    return null;
	  }

	
	}