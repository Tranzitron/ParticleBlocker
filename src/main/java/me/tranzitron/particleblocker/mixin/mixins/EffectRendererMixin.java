package me.tranzitron.particleblocker.mixin.mixins;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({ EffectRenderer.class })
public class EffectRendererMixin
{
    @Shadow protected World worldObj;

    public EffectRendererMixin() {
        super();
    }

    @Inject(method = { "addBlockDestroyEffects" }, at = { @At("HEAD") }, cancellable = true)
    private void removeBlockBreak(BlockPos pos, IBlockState blockState, final CallbackInfo ci) {
        if(Block.isEqualTo(blockState.getBlock() , Blocks.reeds)){
            ci.cancel();
        }
        System.out.println(blockState.getBlock().getRegistryName());
    }

    @Inject(method = { "addBlockHitEffects(Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;)V" }, at = { @At("HEAD") }, cancellable = true)
    private void removeBlockHit(BlockPos pos, EnumFacing facing,final CallbackInfo ci) {
        if(Block.isEqualTo(worldObj.getBlockState(pos).getBlock() , Blocks.reeds)){
            System.out.println(worldObj.getBlockState(pos).getBlock().getRegistryName().toString());
            ci.cancel();
        }
        System.out.println(worldObj.getBlockState(pos).getBlock().getRegistryName());
    }

    @Inject(method = { "addBlockHitEffects(Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/MovingObjectPosition;)V" }, at = { @At("HEAD") }, cancellable = true, remap = false)
    private void removeBlockHit_1(BlockPos pos, MovingObjectPosition movingObjectPosition, final CallbackInfo ci) {
        if(Block.isEqualTo(worldObj.getBlockState(pos).getBlock() , Blocks.reeds)){
            ci.cancel();
        }
        System.out.println(worldObj.getBlockState(pos).getBlock().getRegistryName());
    }
}
