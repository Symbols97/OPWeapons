package com.Symbols97.OPWeapons.mobs.frostdragon;

import org.lwjgl.opengl.GL11;

import com.Symbols97.OPWeapons.mobs.DeadWolf.EntityDeadWolf;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelDragon;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.util.MathHelper;

public class FrostDragonModel extends ModelBase {
    public ModelRenderer Neck;
    public ModelRenderer Torso;
    public ModelRenderer Head;
    public ModelRenderer SnoutTop;
    public ModelRenderer BackRightHip;
    public ModelRenderer BackRightCalf;
    public ModelRenderer BackRightAnkle;
    public ModelRenderer BackLeftHip;
    public ModelRenderer BackLeftCalf;
    public ModelRenderer BackLeftAnkle;
    public ModelRenderer FrontRightShoulder;
    public ModelRenderer FrontRightCalf;
    public ModelRenderer FrontRightAnkle;
    public ModelRenderer FrontLeftShoulder;
    public ModelRenderer FrontLeftCalf;
    public ModelRenderer FrontLeftAnkle;
    public ModelRenderer BackRightFoot;
    public ModelRenderer FrontRightFoot;
    public ModelRenderer FrontLeftFoot;
    public ModelRenderer BackLeftFoot;
    public ModelRenderer Tail;
    public ModelRenderer TailFin;
    public ModelRenderer LeftWing1;
    public ModelRenderer RightWing1;
    public ModelRenderer Horn1;
    public ModelRenderer Horn2;
    public ModelRenderer Horn3;
    public ModelRenderer Horn4;
    public ModelRenderer SnoutBottom;
    public ModelRenderer BRClaw1;
    public ModelRenderer BRClaw2;
    public ModelRenderer BRClaw3;
    public ModelRenderer FRClaw1;
    public ModelRenderer FRClaw2;
    public ModelRenderer FRClaw3;
    public ModelRenderer FLClaw1;
    public ModelRenderer FLClaw2;
    public ModelRenderer FLClaw3;
    public ModelRenderer BLClaw1;
    public ModelRenderer BLClaw2;
    public ModelRenderer BLClaw3;
    public ModelRenderer LeftWing2;
    public ModelRenderer LeftWing3;
    public ModelRenderer RightWing2;
    public ModelRenderer RightWing3;

    public FrostDragonModel() {
    	this.textureWidth = 256;
        this.textureHeight = 256;
        this.BLClaw2 = new ModelRenderer(this, 200, 200);
        this.BLClaw2.setRotationPoint(1.5F, 2.0F, -2.0F);
        this.BLClaw2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
        this.Horn4 = new ModelRenderer(this, 60, 80);
        this.Horn4.setRotationPoint(0.2F, 1.7F, 5.8F);
        this.Horn4.addBox(0.0F, 0.0F, 0.0F, 2, 2, 16, 0.0F);
        this.setRotateAngle(Horn4, 0.3665191429188092F, -0.3141592653589793F, 0.0F);
        this.BackLeftHip = new ModelRenderer(this, 150, 240);
        this.BackLeftHip.setRotationPoint(6.900000000000004F, 4.2F, 30.300000000000004F);
        this.BackLeftHip.addBox(0.0F, 0.0F, 0.0F, 5, 7, 8, 0.0F);
        this.Head = new ModelRenderer(this, 0, 185);
        this.Head.setRotationPoint(-6.099999999999996F, -12.0F, -27.699999999999797F);
        this.Head.addBox(0.0F, 0.0F, 0.0F, 12, 10, 8, 0.0F);
        this.FLClaw1 = new ModelRenderer(this, 200, 200);
        this.FLClaw1.setRotationPoint(0.2F, 2.0F, -2.0F);
        this.FLClaw1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
        this.BLClaw1 = new ModelRenderer(this, 200, 200);
        this.BLClaw1.setRotationPoint(0.2F, 2.0F, -2.0F);
        this.BLClaw1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
        this.BackRightCalf = new ModelRenderer(this, 150, 220);
        this.BackRightCalf.setRotationPoint(0.5F, 7.0F, 0.0F);
        this.BackRightCalf.addBox(0.0F, 0.0F, 0.0F, 4, 10, 4, 0.0F);
        this.setRotateAngle(BackRightCalf, 0.5918411493512771F, 0.0F, 0.0F);
        this.RightWing1 = new ModelRenderer(this, 30, 70);
        this.RightWing1.setRotationPoint(-6.099999999999996F, -5.3F, 0.499999999999967F);
        this.RightWing1.addBox(0.0F, 0.0F, 0.0F, 3, 3, 10, 0.0F);
        this.setRotateAngle(RightWing1, 0.8726646259971648F, -1.5533430342749532F, 0.0F);
        this.BRClaw1 = new ModelRenderer(this, 200, 200);
        this.BRClaw1.setRotationPoint(0.2F, 2.0F, -2.0F);
        this.BRClaw1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
        this.FrontLeftShoulder = new ModelRenderer(this, 150, 240);
        this.FrontLeftShoulder.setRotationPoint(6.900000000000004F, 4.2F, -3.5000000000000155F);
        this.FrontLeftShoulder.addBox(0.0F, 0.0F, 0.0F, 5, 7, 8, 0.0F);
        this.SnoutBottom = new ModelRenderer(this, 0, 130);
        this.SnoutBottom.setRotationPoint(0.0F, 8.0F, 12.0F);
        this.SnoutBottom.addBox(0.0F, 0.0F, -12.0F, 12, 2, 12, 0.0F);
        this.Horn3 = new ModelRenderer(this, 60, 80);
        this.Horn3.setRotationPoint(8.4F, 0.0F, 1.8F);
        this.Horn3.addBox(0.0F, 0.0F, 0.0F, 2, 2, 16, 0.0F);
        this.setRotateAngle(Horn3, 0.5585053606381855F, 0.0F, 0.0F);
        this.FLClaw3 = new ModelRenderer(this, 200, 200);
        this.FLClaw3.setRotationPoint(2.9F, 2.0F, -2.0F);
        this.FLClaw3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
        this.LeftWing3 = new ModelRenderer(this, 100, 20);
        this.LeftWing3.setRotationPoint(-1.0F, 3.0F, 30.0F);
        this.LeftWing3.addBox(0.0F, 0.0F, 0.0F, 39, 1, 22, 0.0F);
        this.setRotateAngle(LeftWing3, 1.6231562043547265F, 0.0F, 0.0F);
        this.TailFin = new ModelRenderer(this, 90, 101);
        this.TailFin.setRotationPoint(-10.099999999999996F, 9.5F, 58.8000000000002F);
        this.TailFin.addBox(0.0F, 0.0F, 0.0F, 19, 1, 20, 0.0F);
        this.setRotateAngle(TailFin, -0.4553564018453205F, 0.0F, 0.0F);
        this.FrontLeftAnkle = new ModelRenderer(this, 150, 200);
        this.FrontLeftAnkle.setRotationPoint(1.0F, 11.9F, 4.2F);
        this.FrontLeftAnkle.addBox(0.0F, 0.0F, 0.0F, 3, 7, 3, 0.0F);
        this.setRotateAngle(FrontLeftAnkle, -0.6981317007977318F, 0.0F, 0.0F);
        this.FrontRightAnkle = new ModelRenderer(this, 150, 200);
        this.FrontRightAnkle.setRotationPoint(1.0F, 11.9F, 4.2F);
        this.FrontRightAnkle.addBox(0.0F, 0.0F, 0.0F, 3, 7, 3, 0.0F);
        this.setRotateAngle(FrontRightAnkle, -0.6981317007977318F, 0.0F, 0.0F);
        this.BackRightAnkle = new ModelRenderer(this, 150, 200);
        this.BackRightAnkle.setRotationPoint(1.0F, 11.9F, 4.2F);
        this.BackRightAnkle.addBox(0.0F, 0.0F, 0.0F, 3, 7, 3, 0.0F);
        this.setRotateAngle(BackRightAnkle, -0.6981317007977318F, 0.0F, 0.0F);
        this.LeftWing1 = new ModelRenderer(this, 0, 70);
        this.LeftWing1.setRotationPoint(8.200000000000005F, -3.3F, 0.499999999999967F);
        this.LeftWing1.addBox(0.0F, 0.0F, 0.0F, 3, 3, 10, 0.0F);
        this.setRotateAngle(LeftWing1, 2.2689280275926285F, -1.5533430342749532F, 0.0F);
        this.Horn2 = new ModelRenderer(this, 60, 80);
        this.Horn2.setRotationPoint(9.8F, 1.7F, 5.8F);
        this.Horn2.addBox(0.0F, 0.0F, 0.0F, 2, 2, 16, 0.0F);
        this.setRotateAngle(Horn2, 0.3665191429188092F, 0.3141592653589793F, 0.0F);
        this.Horn1 = new ModelRenderer(this, 60, 80);
        this.Horn1.setRotationPoint(1.8F, 0.0F, 1.8F);
        this.Horn1.addBox(0.0F, 0.0F, 0.0F, 2, 2, 16, 0.0F);
        this.setRotateAngle(Horn1, 0.5585053606381855F, 0.0F, 0.0F);
        this.RightWing3 = new ModelRenderer(this, 100, 50);
        this.RightWing3.setRotationPoint(-1.0F, 0.0F, 30.1F);
        this.RightWing3.addBox(0.0F, 0.0F, 0.0F, 39, 1, 22, 0.0F);
        this.setRotateAngle(RightWing3, -1.6231562043547265F, 0.0F, 0.0F);
        this.BackLeftAnkle = new ModelRenderer(this, 150, 200);
        this.BackLeftAnkle.setRotationPoint(1.0F, 11.9F, 4.2F);
        this.BackLeftAnkle.addBox(0.0F, 0.0F, 0.0F, 3, 7, 3, 0.0F);
        this.setRotateAngle(BackLeftAnkle, -0.6981317007977318F, 0.0F, 0.0F);
        this.FRClaw2 = new ModelRenderer(this, 200, 200);
        this.FRClaw2.setRotationPoint(1.5F, 2.0F, -2.0F);
        this.FRClaw2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
        this.BRClaw2 = new ModelRenderer(this, 200, 200);
        this.BRClaw2.setRotationPoint(1.5F, 2.0F, -2.0F);
        this.BRClaw2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
        this.FRClaw1 = new ModelRenderer(this, 200, 200);
        this.FRClaw1.setRotationPoint(0.2F, 2.0F, -2.0F);
        this.FRClaw1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
        this.FrontRightShoulder = new ModelRenderer(this, 150, 240);
        this.FrontRightShoulder.setRotationPoint(-12.099999999999996F, 4.2F, -3.5000000000000155F);
        this.FrontRightShoulder.addBox(0.0F, 0.0F, 0.0F, 5, 7, 8, 0.0F);
        this.BackRightFoot = new ModelRenderer(this, 150, 180);
        this.BackRightFoot.setRotationPoint(0.5F, 16.8F, -4.8F);
        this.BackRightFoot.addBox(0.0F, 0.0F, 0.0F, 4, 3, 11, 0.0F);
        this.RightWing2 = new ModelRenderer(this, 0, 0);
        this.RightWing2.setRotationPoint(-1.0F, 0.0F, 8.0F);
        this.RightWing2.addBox(0.0F, 0.0F, 0.0F, 18, 1, 22, 0.0F);
        this.Neck = new ModelRenderer(this, 0, 205);
        this.Neck.setRotationPoint(-5.099999999999996F, -11.9F, -22.099999999999795F);
        this.Neck.addBox(0.0F, 0.0F, 0.0F, 10, 8, 16, 0.0F);
        this.setRotateAngle(Neck, -0.2617993877991494F, 0.0F, 0.0F);
        this.FrontRightFoot = new ModelRenderer(this, 150, 180);
        this.FrontRightFoot.setRotationPoint(0.5F, 16.8F, -4.8F);
        this.FrontRightFoot.addBox(0.0F, 0.0F, 0.0F, 4, 3, 11, 0.0F);
        this.Torso = new ModelRenderer(this, 15, 185);
        this.Torso.setRotationPoint(-8.099999999999996F, -8.8F, -9.499999999999911F);
        this.Torso.addBox(0.0F, 0.0F, 0.0F, 16, 17, 48, 0.0F);
        this.FrontRightCalf = new ModelRenderer(this, 150, 220);
        this.FrontRightCalf.setRotationPoint(0.5F, 7.0F, 0.0F);
        this.FrontRightCalf.addBox(0.0F, 0.0F, 0.0F, 4, 10, 4, 0.0F);
        this.setRotateAngle(FrontRightCalf, 0.5918411493512771F, 0.0F, 0.0F);
        this.Tail = new ModelRenderer(this, 150, 90);
        this.Tail.setRotationPoint(-3.100000000000001F, -5.8F, 36.000000000000206F);
        this.Tail.addBox(0.0F, 0.0F, 0.0F, 5, 5, 37, 0.0F);
        this.setRotateAngle(Tail, -0.5009094953223726F, 0.0F, 0.0F);
        this.FrontLeftFoot = new ModelRenderer(this, 150, 180);
        this.FrontLeftFoot.setRotationPoint(0.5F, 16.8F, -4.8F);
        this.FrontLeftFoot.addBox(0.0F, 0.0F, 0.0F, 4, 3, 11, 0.0F);
        this.FLClaw2 = new ModelRenderer(this, 200, 200);
        this.FLClaw2.setRotationPoint(1.5F, 2.0F, -2.0F);
        this.FLClaw2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
        this.SnoutTop = new ModelRenderer(this, 0, 150);
        this.SnoutTop.setRotationPoint(0.0F, 0.0F, -11.2F);
        this.SnoutTop.addBox(0.0F, 0.0F, 0.0F, 12, 8, 12, 0.0F);
        this.BackLeftCalf = new ModelRenderer(this, 150, 220);
        this.BackLeftCalf.setRotationPoint(0.5F, 7.0F, 0.6F);
        this.BackLeftCalf.addBox(0.0F, 0.0F, 0.0F, 4, 10, 4, 0.0F);
        this.setRotateAngle(BackLeftCalf, 0.5918411493512771F, 0.0F, 0.0F);
        this.FRClaw3 = new ModelRenderer(this, 200, 200);
        this.FRClaw3.setRotationPoint(2.9F, 2.0F, -2.0F);
        this.FRClaw3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
        this.BackRightHip = new ModelRenderer(this, 150, 240);
        this.BackRightHip.setRotationPoint(-12.099999999999996F, 4.2F, 30.300000000000203F);
        this.BackRightHip.addBox(0.0F, 0.0F, 0.0F, 5, 7, 8, 0.0F);
        this.LeftWing2 = new ModelRenderer(this, 0, 40);
        this.LeftWing2.setRotationPoint(-1.0F, 2.0F, 8.0F);
        this.LeftWing2.addBox(0.0F, 0.0F, 0.0F, 18, 1, 22, 0.0F);
        this.BackLeftFoot = new ModelRenderer(this, 150, 180);
        this.BackLeftFoot.setRotationPoint(0.5F, 16.8F, -4.8F);
        this.BackLeftFoot.addBox(0.0F, 0.0F, 0.0F, 4, 3, 11, 0.0F);
        this.BLClaw3 = new ModelRenderer(this, 200, 200);
        this.BLClaw3.setRotationPoint(2.9F, 2.0F, -2.0F);
        this.BLClaw3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
        this.FrontLeftCalf = new ModelRenderer(this, 150, 220);
        this.FrontLeftCalf.setRotationPoint(0.5F, 7.0F, 0.0F);
        this.FrontLeftCalf.addBox(0.0F, 0.0F, 0.0F, 4, 10, 4, 0.0F);
        this.setRotateAngle(FrontLeftCalf, 0.5918411493512771F, 0.0F, 0.0F);
        this.BRClaw3 = new ModelRenderer(this, 200, 200);
        this.BRClaw3.setRotationPoint(2.9F, 2.0F, -2.0F);
        this.BRClaw3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(BRClaw3, -0.011519173063162576F, 0.0F, 0.0F);
        this.BackLeftFoot.addChild(this.BLClaw2);
        this.Head.addChild(this.Horn4);
        this.FrontLeftFoot.addChild(this.FLClaw1);
        this.BackLeftFoot.addChild(this.BLClaw1);
        this.BackRightHip.addChild(this.BackRightCalf);
        this.BackRightFoot.addChild(this.BRClaw1);
        this.SnoutTop.addChild(this.SnoutBottom);
        this.Head.addChild(this.Horn3);
        this.FrontLeftFoot.addChild(this.FLClaw3);
        this.LeftWing1.addChild(this.LeftWing3);
        this.FrontLeftShoulder.addChild(this.FrontLeftAnkle);
        this.FrontRightShoulder.addChild(this.FrontRightAnkle);
        this.BackRightHip.addChild(this.BackRightAnkle);
        this.Head.addChild(this.Horn2);
        this.Head.addChild(this.Horn1);
        this.RightWing1.addChild(this.RightWing3);
        this.BackLeftHip.addChild(this.BackLeftAnkle);
        this.FrontRightFoot.addChild(this.FRClaw2);
        this.BackRightFoot.addChild(this.BRClaw2);
        this.FrontRightFoot.addChild(this.FRClaw1);
        this.BackRightHip.addChild(this.BackRightFoot);
        this.RightWing1.addChild(this.RightWing2);
        this.FrontRightShoulder.addChild(this.FrontRightFoot);
        this.FrontRightShoulder.addChild(this.FrontRightCalf);
        this.FrontLeftShoulder.addChild(this.FrontLeftFoot);
        this.FrontLeftFoot.addChild(this.FLClaw2);
        this.Head.addChild(this.SnoutTop);
        this.BackLeftHip.addChild(this.BackLeftCalf);
        this.FrontRightFoot.addChild(this.FRClaw3);
        this.LeftWing1.addChild(this.LeftWing2);
        this.BackLeftHip.addChild(this.BackLeftFoot);
        this.BackLeftFoot.addChild(this.BLClaw3);
        this.FrontLeftShoulder.addChild(this.FrontLeftCalf);
        this.BackRightFoot.addChild(this.BRClaw3);
        
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
    	this.TailFin.render(f5);
        this.Neck.render(f5);
        this.BackRightHip.render(f5);
        this.BackLeftHip.render(f5);
        this.Torso.render(f5);
        this.RightWing1.render(f5);
        this.FrontRightShoulder.render(f5);
        this.Tail.render(f5);
        this.Head.render(f5);
        this.FrontLeftShoulder.render(f5);
        this.LeftWing1.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    
    
    public void setLivingAnimations(EntityLivingBase p_78086_1_, float p_78086_2_, float p_78086_3_, float p_78086_4_)
    {
        EntityFrostDragon entityfrostdragon = (EntityFrostDragon)p_78086_1_;
        
        this.SnoutBottom.rotateAngleX = 0.0F + 0.25707964F * p_78086_3_;
       
        this.BackLeftHip.rotateAngleX = MathHelper.cos(p_78086_2_ * 0.4662F + (float)Math.PI) * 1.4F * p_78086_3_; 
        this.BackRightHip.rotateAngleX = MathHelper.cos(p_78086_2_ * 0.4662F) * 1.4F * p_78086_3_;   
        this.FrontRightShoulder.rotateAngleX = MathHelper.cos(p_78086_2_ * 0.4662F + (float)Math.PI) * 1.4F * p_78086_3_;
        this.FrontLeftShoulder.rotateAngleX = MathHelper.cos(p_78086_2_ * 0.4662F) * 1.4F * p_78086_3_;
        
        
    }
    
    
    
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
