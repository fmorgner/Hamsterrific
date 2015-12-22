package es.razzleberri.hamsterrific.entity;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class RegularHamster extends Hamster {
    public RegularHamster(World world) {
        super(world);
        addBreedingItem(Items.pumpkin_seeds);
    }

    @Override
    public EntityAgeable createChild(EntityAgeable ageable) {
        return null;
    }

}
