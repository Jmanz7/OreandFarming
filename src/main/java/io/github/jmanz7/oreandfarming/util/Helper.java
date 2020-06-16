package io.github.jmanz7.oreandfarming.util;

import net.minecraft.entity.Entity;
import net.minecraft.util.Direction;

public class Helper
{
    public static Direction getFacing(Entity entity)
    {
        return entity.rotationPitch < -45 ? Direction.UP
             : entity.rotationPitch > 45 ? Direction.DOWN
             : entity.getHorizontalFacing();
    }
}
