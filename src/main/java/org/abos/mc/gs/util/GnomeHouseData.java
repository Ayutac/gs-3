package org.abos.mc.gs.util;

import net.minecraft.world.inventory.ContainerData;
import org.abos.mc.gs.block.entity.AbstractGnomeHouseBlockEntity;

import java.util.Objects;

public class GnomeHouseData implements ContainerData {
    
    protected AbstractGnomeHouseBlockEntity blockEntity;
    
    public GnomeHouseData(AbstractGnomeHouseBlockEntity blockEntity) {
        this.blockEntity = Objects.requireNonNull(blockEntity);
    }

    @Override
    public int get(int i) {
        return switch (i) {
            case 0 -> blockEntity.getTickCounter();
            case 1 -> blockEntity.getWorkCounter();
            default -> blockEntity.hasFood() ? 1 : 0;
        };
    }

    @Override
    public void set(int i, int i1) {
        // Not needed
    }

    @Override
    public int getCount() {
        return 3;
    }
    
}
