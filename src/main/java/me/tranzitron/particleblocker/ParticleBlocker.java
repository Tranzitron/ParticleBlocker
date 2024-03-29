package me.tranzitron.particleblocker;

import cc.polyfrost.oneconfig.events.event.InitializationEvent;
import cc.polyfrost.oneconfig.utils.commands.CommandManager;
import me.tranzitron.particleblocker.command.ExampleCommand;
import me.tranzitron.particleblocker.config.PBConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

/**
 * The entrypoint of the Example Mod that initializes it.
 *
 * @see Mod
 * @see InitializationEvent
 */
@Mod(modid = ParticleBlocker.MODID, name = ParticleBlocker.NAME, version = ParticleBlocker.VERSION)
public class ParticleBlocker {
    // Sets the variables from `gradle.properties`. NOT TOUCH.
    public static final String MODID = "@ID@";
    public static final String NAME = "@NAME@";
    public static final String VERSION = "@VER@";
    @Mod.Instance(MODID)
    public static ParticleBlocker INSTANCE; // Adds the instance of the mod, so we can access other variables.
    public static PBConfig config;

    // Register the config and commands.
    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {
        config = new PBConfig();

        CommandManager.INSTANCE.registerCommand(new ExampleCommand());
    }

}
