package me.tranzitron.particleblocker.config;

import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.annotations.Switch;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;
import cc.polyfrost.oneconfig.config.data.OptionSize;

public class PBConfig extends Config {

    @Switch(
            name = "Master Switch",
            size = OptionSize.DUAL,
            description = "Toggles ParticleBlocker Mod",
            category = "Particles"
    )
    public static boolean masterSwitch = false;
    @Switch(
            name = "logs",
            size = OptionSize.DUAL,
            description = "Toggle All Logs",
            category = "Particles",
            subcategory = "Block Categories"
    )
    public static boolean logs = false;
    @Switch(
            name = "farming",
            size = OptionSize.DUAL,
            description = "Toggle Farming Blocks",
            category = "Particles"
    )
    public static boolean farming = false;


    public PBConfig(){
        //TODO Create Icon & Add It
        super(new Mod("Particle Blocker", ModType.UTIL_QOL), "ParticleBlocker.json");
        addDependency("logs", "logs");

        hideIf("logs", () -> masterSwitch);
        initialize();
    }

    private void todolist(){
        // TODO (Toggling by type
        //  Logs,Farms,Stones)
    }
}
