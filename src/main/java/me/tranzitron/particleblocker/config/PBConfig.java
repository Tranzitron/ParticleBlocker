package me.tranzitron.particleblocker.config;

import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.annotations.Switch;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;
import cc.polyfrost.oneconfig.config.data.OptionSize;

public class PBConfig extends Config {
    public static String[] farmList = new String[0];
    public static String[] logList = new String[0];
    //    @Switch(
//            name = "Master Switch",
//            size = OptionSize.DUAL,
//            description = "Toggles ParticleBlocker Mod",
//            category = "Particles"
//    )
//    public static boolean masterSwitch = false;
    @Switch(
            name = "Logs",
            size = OptionSize.DUAL,
            description = "Toggle All Logs",
            category = "Particles",
            subcategory = "Block Categories"
    )
    public static boolean logs = false;
    @Switch(
            name = "Farming",
            size = OptionSize.DUAL,
            description = "Toggle Farming Blocks",
            category = "Particles"
    )
    public static boolean farming = false;
    @Switch(
            name = "Master Switch",
            size = OptionSize.DUAL
    )
    public static boolean masterSwitch = false;

    @Switch(
            name = "Sub Switch",
            size = OptionSize.DUAL
    )
    public static boolean subSwitch = false;


    public PBConfig() {
        super(new Mod("Particle Blocker", ModType.UTIL_QOL), "ParticleBlocker.json");

        farmList = new String[]{"minecraft:reeds", "minecraft:wheat", "minecraft:pumpkin", "minecraft:melon_block", "minecraft:potatoes",
                "minecraft:carrots", "minecraft:nether_wart", "minecraft:cocoa", "minecraft:cactus", "minecraft:brown_mushroom", "minecraft:red_mushroom"};
        logList = new String[]{"minecraft:log", "minecraft:log2"};

        //TODO Create Icon & Add It
        addDependency("Logs", "Master Switch", () -> masterSwitch);
        addDependency("subSwitch", "masterSwitch", () -> masterSwitch);
        initialize();
    }

    private void todolist() {
        // TODO (Toggling by type
        //  Logs,Farms,Stones)
    }
}
