package es.razzleberri.hamsterrific.entity;

import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public abstract class Hamster extends EntityTameable{

    private final List<Integer> m_breedingItems;

    public Hamster(World world) {
        super(world);
        this.allowLeashing();
        m_breedingItems = new ArrayList<>();
    }

    protected final void addBreedingItem(Item item) {
        m_breedingItems.add(Item.getIdFromItem(item));
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return m_breedingItems.contains(Item.getIdFromItem(stack.getItem()));
    }
}
