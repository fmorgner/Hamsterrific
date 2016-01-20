package es.razzleberri.hamsterrific.entity;

import es.razzleberri.hamsterrific.Hamsterrific;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public abstract class EntityHamster extends EntityTameable {

  private final List<Integer> m_breedingItems;
  private final List<Integer> m_foodItems;

  private int m_foodLevel = 0;

  public EntityHamster(World world) {
    super(world);

    setHealth(10);
    setSize(.25f, .3f);

    tasks.addTask(0, new EntityAILookIdle(this));
    tasks.addTask(0, new EntityAIWatchClosest(this, EntityPlayer.class, 80.0f));

    m_breedingItems = new ArrayList<>();
    m_foodItems = new ArrayList<>();
  }

  public int getFoodLevel() {
    return m_foodLevel;
  }

  protected final void addBreedingItem(Item item) {
    m_breedingItems.add(Item.getIdFromItem(item));
  }

  protected final void addFoodItem(Item item) {
    m_foodItems.add(Item.getIdFromItem(item));
  }

  protected final void consumeFood() {
    if (m_foodLevel > 0) {
      --m_foodLevel;
    }
  }

  protected abstract void updateFoodLevel();

  private boolean handleEatableItem(EntityPlayer player) {
    ItemStack heldItem = player.getHeldItem();

    if (m_foodLevel < 4) {
      consumeItemFromStack(player, heldItem);

      if (++m_foodLevel == 4 && isBreedingItem(heldItem)) {
        setInLove(player);
      }

      return true;
    }

    return false;
  }

  private boolean isEatable(ItemStack stack) {
    return isBreedingItem(stack) || m_foodItems.contains(Item.getIdFromItem(stack.getItem()));
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

  @Override
  public boolean interact(EntityPlayer player) {
    if (isEatable(player.getHeldItem())) {
      return handleEatableItem(player);
    }

    return false;
  }

  @Override
  public void onLivingUpdate() {
    updateFoodLevel();

    super.onLivingUpdate();
  }

}
