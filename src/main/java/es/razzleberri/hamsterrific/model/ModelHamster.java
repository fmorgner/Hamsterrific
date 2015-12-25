package es.razzleberri.hamsterrific.model;

import es.razzleberri.hamsterrific.entity.EntityHamster;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public class ModelHamster extends ModelBase {

  public static final float SCALE_FACTOR_CHEEKS_BASE = 0.05f;
  public static final float SCALE_FACTOR_CHEEKS_STEP = 0.02f;

  private ModelRenderer m_body;

  private ModelRenderer m_head;

  private ModelRenderer m_legFrontRight;
  private ModelRenderer m_legFrontLeft;
  private ModelRenderer m_legBackRight;
  private ModelRenderer m_legBackLeft;

  private ModelRenderer m_cheekLeft;
  private ModelRenderer m_cheekRight;

  public ModelHamster() {
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

    m_cheekLeft = new ModelRenderer(this, 4, 23);
    m_cheekLeft.addBox(0, -0.5f, -0.5f, 1, 1, 1);
    m_cheekLeft.setRotationPoint(2.f, 0, -2.5f);

    m_cheekRight = new ModelRenderer(this, 4, 23);
    m_cheekRight.addBox(-1.f, -0.5f, -0.5f, 1, 1, 1);
    m_cheekRight.setRotationPoint(-2.f, 0, -2.5f);

    m_head = new ModelRenderer(this, 0, 0);
    m_head.addBox(-2.5f, -3.5f, -5.0f, 5, 5, 5, 0.1f);
    m_head.setRotationPoint(0, -2.5f, -4.0f);
    m_head.addChild(m_cheekLeft);
    m_head.addChild(m_cheekRight);

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
    updateCheeks((EntityHamster) entity);
    m_body.render(scale);
  }

  @Override
  public void setRotationAngles(float distanceMoved, float speed, float timeExisted, float lookX, float lookY, float scale, Entity entity) {
    m_head.rotateAngleX = (float) (lookY / (180 / Math.PI));
    m_head.rotateAngleY = (float) (lookX / (180 / Math.PI));
  }

  private void updateCheeks(EntityHamster hamster) {
    m_cheekLeft.compileDisplayList(SCALE_FACTOR_CHEEKS_BASE + SCALE_FACTOR_CHEEKS_STEP * hamster.getFoodLevel());
    m_cheekRight.compileDisplayList(SCALE_FACTOR_CHEEKS_BASE + SCALE_FACTOR_CHEEKS_STEP * hamster.getFoodLevel());
  }

}
