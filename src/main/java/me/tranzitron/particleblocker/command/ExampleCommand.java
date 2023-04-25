package me.tranzitron.particleblocker.command;

import me.tranzitron.particleblocker.ParticleBlocker;
import cc.polyfrost.oneconfig.utils.commands.annotations.Command;
import cc.polyfrost.oneconfig.utils.commands.annotations.Main;

/**
 * An example command implementing the Command api of OneConfig.
 * Registered in ExampleMod.java with `CommandManager.INSTANCE.registerCommand(new ExampleCommand());`
 *
 * @see Command
 * @see Main
 * @see ParticleBlocker
 */
@Command(value = ParticleBlocker.MODID, description = "Access the " + ParticleBlocker.NAME + " GUI.")
public class ExampleCommand {
    @Main
    private void handle() {
        ParticleBlocker.INSTANCE.config.openGui();
    }
}