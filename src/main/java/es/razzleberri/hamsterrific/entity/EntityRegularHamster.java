package es.razzleberri.hamsterrific.entity;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.init.Items;
import net.minecraft.world.World;

public class EntityRegularHamster extends EntityHamster {

  public EntityRegularHamster(World world) {
    super(world);

    addBreedingItem(Items.pumpkin_seeds);

    addFoodItem(Items.wheat_seeds);
    addFoodItem(Items.melon_seeds);
  }

  @Override
  public EntityAgeable createChild(EntityAgeable ageable) {
    return null;
  }

  @Override
  protected void updateFoodLevel() {
    if (rand.nextInt(42) == 0 && rand.nextInt(42) == 0) {
      consumeFood();
    }
  }
}
