package es.razzleberri.hamsterrific.entity;

import es.razzleberri.hamsterrific.Hamsterrific;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public abstract class EntityHamster extends EntityTameable {

  private final List<Integer> m_breedingItems;

  public EntityHamster(World world) {
    super(world);

    setHealth(10);
    setSize(.25f, .3f);

    m_breedingItems = new ArrayList<>();
  }

  protected final void addBreedingItem(Item item) {
    m_breedingItems.add(Item.getIdFromItem(item));
  }

  @Override
  public boolean isBreedingItem(ItemStack stack) {
    return m_breedingItems.contains(Item.getIdFromItem(stack.getItem()));
  }

  @Override
  public float getEyeHeight() {
    return height * .8f;
  }

  @Override
  protected String getHurtSound() {
    return Hamsterrific.MOD_ID + ":hurtSound";
  }

  @Override
  protected String getLivingSound() {
    return Hamsterrific.MOD_ID + ":livingSound";
  }

  @Override
  protected String getDeathSound() {
    return Hamsterrific.MOD_ID + ":deathSound";
  }
  
}
