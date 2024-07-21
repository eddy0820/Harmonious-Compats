package net.eddy0820.harmoniouscompats.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.common.block.MushroomColonyBlock;

import java.util.function.Supplier;

public class GlowShroomColonyBlock extends MushroomColonyBlock
{

    public GlowShroomColonyBlock(Properties properties, Supplier<Item> mushroomType) {
        super(properties, mushroomType);
    }

    @Override
    public void animateTick(@NotNull BlockState stateIn, @NotNull Level worldIn, @NotNull BlockPos pos, @NotNull RandomSource rand) {
        super.animateTick(stateIn, worldIn, pos, rand);
        if (rand.nextInt(12) == 0 && worldIn.getBlockState(pos.above()).isAir()) {
            worldIn.addParticle(ParticleTypes.END_ROD, (double)pos.getX() + 0.4 + rand.nextDouble() * 0.2, (double)pos.getY() + 0.5 + rand.nextDouble() * 0.1, (double)pos.getZ() + 0.4 + rand.nextDouble() * 0.2, (Math.random() - 0.5) * 0.04, (1.0 + Math.random()) * 0.02, (Math.random() - 0.5) * 0.04);
        }

    }
}
