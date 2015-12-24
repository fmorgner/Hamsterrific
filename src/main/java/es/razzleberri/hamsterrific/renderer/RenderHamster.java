package es.razzleberri.hamsterrific.renderer;

import es.razzleberri.hamsterrific.Hamsterrific;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderHamster extends RenderLiving {

  public RenderHamster(ModelBase modelbaseIn, float shadowsizeIn) {
    super(Minecraft.getMinecraft().getRenderManager(), modelbaseIn, shadowsizeIn);
  }

  @Override
  protected void preRenderCallback(EntityLivingBase entitylivingbaseIn, float partialTickTime) {
    GlStateManager.scale(.5, .5, .5);
  }

  @Override
  protected ResourceLocation getEntityTexture(Entity entity) {
    return new ResourceLocation(Hamsterrific.MOD_ID + ":textures/entity/hamster/darkbrown.png");
  }

}
