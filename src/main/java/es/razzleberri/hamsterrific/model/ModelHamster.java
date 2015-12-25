package es.razzleberri.hamsterrific.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public class ModelHamster extends ModelBase {

  private ModelRenderer m_body;
  private ModelRenderer m_head;
  private ModelRenderer m_legFrontRight;
  private ModelRenderer m_legFrontLeft;
  private ModelRenderer m_legBackRight;
  private ModelRenderer m_legBackLeft;

  public ModelHamster() {
    m_head = new ModelRenderer(this, 0, 0);
    m_head.addBox(-2.5f, -3.5f, -2.5f, 5, 5, 5);
    m_head.setRotationPoint(0, -2.5f, -3.5f);

    m_legFrontRight = new ModelRenderer(this, 0, 23);
    m_legFrontRight.addBox(-.5f, 0, -.5f, 1, 2, 1);
    m_legFrontRight.setRotationPoint(-2.1f, -.5f, -3.6f);

    m_legFrontLeft = new ModelRenderer(this, 0, 23);
    m_legFrontLeft.addBox(-.5f, 0, -.5f, 1, 2, 1);
    m_legFrontLeft.setRotationPoint(2.1f, -.5f, -3.6f);

    m_legBackRight = new ModelRenderer(this, 0, 23);
    m_legBackRight.addBox(-.5f, 0, -.5f, 1, 2, 1);
    m_legBackRight.setRotationPoint(-2.1f, -.5f, 3.6f);

    m_legBackLeft = new ModelRenderer(this, 0, 23);
    m_legBackLeft.addBox(-.5f, 0, -.5f, 1, 2, 1);
    m_legBackLeft.setRotationPoint(2.1f, -.5f, 3.6f);


    m_body = new ModelRenderer(this, 0, 10);
    m_body.addBox(-2.5f, -5.0f, -4.0f, 5, 5, 8);
    m_body.setRotationPoint(0, 22.5f, 0);
    m_body.addChild(m_head);
    m_body.addChild(m_legFrontRight);
    m_body.addChild(m_legFrontLeft);
    m_body.addChild(m_legBackRight);
    m_body.addChild(m_legBackLeft);
  }

  @Override
  public void setLivingAnimations(EntityLivingBase entity, float f1, float f2, float partialTickTime) {
  }

  @Override
  public void render(Entity entity, float distanceMoved, float speed, float timeExisted, float lookX, float lookY, float scale) {
    m_body.render(scale);
  }

  @Override
  public void setRotationAngles(float distanceMoved, float speed, float timeExisted, float lookX, float lookY, float scale, Entity entity) {
    m_head.rotateAngleX = (float) (lookY / (180 / Math.PI));
    m_head.rotateAngleY = (float) (lookX / (180 / Math.PI));
  }
}
