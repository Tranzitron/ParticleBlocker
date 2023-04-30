package me.tranzitron.particleblocker.mixin.mixins;

import me.tranzitron.particleblocker.config.PBConfig;
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

import java.util.ArrayList;
import java.util.Arrays;

@Mixin({ EffectRenderer.class })
public class EffectRendererMixin
{
    private ArrayList<Block> logBlocks = new ArrayList<>();


    @Shadow protected World worldObj;
    public EffectRendererMixin() {
        logBlocks.add(Blocks.log);
    }

    @Inject(method = { "addBlockDestroyEffects" }, at = { @At("HEAD") }, cancellable = true)
    private void removeBlockBreak(BlockPos pos, IBlockState blockState, final CallbackInfo ci) {
        if(PBConfig.masterSwitch){
            Block block = blockState.getBlock();
            if(hasNoParticle(block)){
                ci.cancel();
            }
        }
        System.out.println(blockState.getBlock().getRegistryName());
    }

    @Inject(method = { "addBlockHitEffects(Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;)V" }, at = { @At("HEAD") }, cancellable = true)
    private void removeBlockHit(BlockPos pos, EnumFacing facing,final CallbackInfo ci) {
        if(PBConfig.masterSwitch) {
            Block block = worldObj.getBlockState(pos).getBlock();
            if(hasNoParticle(block)){
                ci.cancel();
            }
        }
    }

    @Inject(method = { "addBlockHitEffects(Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/MovingObjectPosition;)V" }, at = { @At("HEAD") }, cancellable = true, remap = false)
    private void removeBlockHit_1(BlockPos pos, MovingObjectPosition movingObjectPosition, final CallbackInfo ci) {
        if(PBConfig.masterSwitch) {
            Block block = worldObj.getBlockState(pos).getBlock();
            if(hasNoParticle(block)){
                ci.cancel();
            }
        }
    }

    private boolean hasNoParticle(Block b){
        String[] logList = new String[]{"minecraft:log","minecraft:log2"};
        if(Arrays.asList(logList).contains(b.getRegistryName())){
            return PBConfig.logs;
        }
        String[] farmList = new String[]{
                "minecraft:reeds", "minecraft:wheat","minecraft:pumpkin", "minecraft:melon_block",
                "minecraft:potatoes","minecraft:carrots","minecraft:nether_wart","minecraft:cocoa",
                "minecraft:cactus","minecraft:brown_mushroom","minecraft:red_mushroom"};
        if(Arrays.asList(farmList).contains(b.getRegistryName())){
            return PBConfig.farming;
        }
        return false;
    }
}
