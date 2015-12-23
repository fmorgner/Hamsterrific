package es.razzleberri.hamsterrific.model;

import es.razzleberri.hamsterrific.Hamsterrific;
import net.minecraft.block.BlockRedstoneComparator;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import org.lwjgl.opengl.GL11;

public class ModelHamster extends ModelBase {

  private ModelRenderer m_body;
  private ModelRenderer m_head;

  public ModelHamster() {
    m_head = new ModelRenderer(this, 0, 0);
    m_head.addBox(-2.5f, -1.5f, -7.5f, 5, 5, 5, -.51f);

    m_body = new ModelRenderer(this, 0, 10);
    m_body.addBox(-2.5f, 0, -4.0f, 5, 5, 8, -.5f);
    m_body.setRotationPoint(0, 16, 0);
    m_body.addChild(m_head);
  }

  @Override
  public void setLivingAnimations(EntityLivingBase entity, float f1, float f2, float partialTickTime) {
  }

  @Override
  public void render(Entity entity, float time, float speed, float rotation, float headRotationX, float headRotationY, float scale) {
    setRotationAngles(time, speed, rotation, headRotationX, headRotationY, scale, entity);

    m_body.render(scale);
  }

  @Override
  public void setRotationAngles(float time, float speed, float rotation, float headRotationX, float headRotationY, float scale, Entity entity) {

  }
}
