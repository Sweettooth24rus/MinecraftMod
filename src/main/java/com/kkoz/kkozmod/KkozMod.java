package com.kkoz.kkozmod;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("kkozmod")
public class KkozMod {
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();

    public KkozMod() {
        MinecraftForge.EVENT_BUS.register(this);

    }
}
