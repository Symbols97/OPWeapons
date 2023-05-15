package com.Symbols97.OPWeapons.models.Armors;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelBiped - Either Mojang or a mod author
 * Created using Tabula 4.1.1
 */
public class ReaperModel extends ModelBiped {
   
    public ModelRenderer spinemain;
    public ModelRenderer spinetop;
    public ModelRenderer spinetopleft;
    public ModelRenderer spinetopright;
    public ModelRenderer spinemiddle;
    public ModelRenderer spinebottomright;
    public ModelRenderer spinebottomleft;

    public ReaperModel(float expand) {
     
    	super(expand,0,64,64);
    	
       
    	this.spinemain = new ModelRenderer(this, 0, 33);
        this.spinemain.setRotationPoint(-1.0F, 2.0F, 1.4F);
        this.spinemain.addBox(0.0F, 0.0F, 0.0F, 2, 8, 1, 0.0F);

        this.spinetop = new ModelRenderer(this, 0, 43);
        this.spinetop.setRotationPoint(0.0F, 3.0F, 1.4F);
        this.spinetop.addBox(-4.0F, 0.0F, 0.0F, 8, 1, 1, 0.0F);
        
        this.spinetopleft = new ModelRenderer(this, 11, 43);
        this.spinetopleft.setRotationPoint(1.0F, 4.0F, 1.4F);
        this.spinetopleft.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        
        this.spinetopright = new ModelRenderer(this, 11, 43);
        this.spinetopright.setRotationPoint(-2.0F, 4.0F, 1.4F);
        this.spinetopright.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
 
        this.spinemiddle = new ModelRenderer(this, 18, 43);
        this.spinemiddle.setRotationPoint(0.0F, 6.0F, 1.4F);
        this.spinemiddle.addBox(-4.0F, 0.0F, 0.0F, 8, 1, 1, 0.0F);
        
        this.spinebottomleft = new ModelRenderer(this, 36, 43);
        this.spinebottomleft.setRotationPoint(0.0F, 8.0F, 1.4F);
        this.spinebottomleft.addBox(1.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
        
        this.spinebottomright = new ModelRenderer(this, 36, 43);
        this.spinebottomright.setRotationPoint(0.0F, 8.0F, 1.4F);
        this.spinebottomright.addBox(-3.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
        
        
        
        this.bipedBody.addChild(spinemain);
        this.bipedBody.addChild(spinetopleft);
        this.bipedBody.addChild(spinetopright);
        this.bipedBody.addChild(spinetop);
        this.bipedBody.addChild(spinemiddle);
        this.bipedBody.addChild(spinebottomleft);
        this.bipedBody.addChild(spinebottomright);
       
        

        
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        
      }
      
      private void setRotation(ModelRenderer model, float x, float y, float z)
      {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
      }
      

    }