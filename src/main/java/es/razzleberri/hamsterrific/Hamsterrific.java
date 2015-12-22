package es.razzleberri.hamsterrific;

import es.razzleberri.hamsterrific.entity.RegularHamster;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import org.apache.logging.log4j.Logger;

import java.io.File;

@Mod(modid = Hamsterrific.MOD_ID, version = Hamsterrific.MOD_VERSION, name = Hamsterrific.MOD_NAME)
public class Hamsterrific {

    public static final String MOD_ID = "es.razzleberri.hamsterrific";
    public static final String MOD_VERSION = "0.3";
    public static final String MOD_NAME = "Hamsterrific";

    public static final Logger LOGGER = FMLLog.getLogger();

    private Configuration m_configuration;

    @Mod.EventHandler
    public void handlePreInit(FMLPreInitializationEvent event) {
        File configFile = event.getSuggestedConfigurationFile();
        m_configuration = new Configuration(configFile);
        m_configuration.load();
    }

    @Mod.EventHandler
    public void handleInit(FMLInitializationEvent event) {
        LOGGER.info("Initializing " + MOD_NAME);

        EntityRegistry.registerGlobalEntityID(RegularHamster.class, "regularHamster", EntityRegistry.findGlobalUniqueEntityId());
    }
}
