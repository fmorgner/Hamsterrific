package es.razzleberri.hamsterrific;

import es.razzleberri.hamsterrific.entity.RegularHamster;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import org.apache.logging.log4j.Logger;

import static es.razzleberri.hamsterrific.constants.Configuration.CAT_ENTITIES;
import static es.razzleberri.hamsterrific.constants.Configuration.PROP_REGULAR_HAMSTER;

@Mod(modid = Hamsterrific.MOD_ID, version = Hamsterrific.MOD_VERSION)
public class Hamsterrific {

  public static final String MOD_ID = "@MODID@";
  public static final String MOD_VERSION = "@MODVERSION@";
  public static final String MOD_NAME = "@MODNAME@";

  public static final Logger LOGGER = FMLLog.getLogger();

  private Configuration m_configuration;
  private Property m_regularHamsterId;

  @EventHandler
  public void onPreInit(FMLPreInitializationEvent event) {
    m_configuration = new Configuration(event.getSuggestedConfigurationFile());
    m_configuration.load();

    m_regularHamsterId = m_configuration.get(CAT_ENTITIES, PROP_REGULAR_HAMSTER, EntityRegistry.findGlobalUniqueEntityId());
  }

  @EventHandler
  public void onInit(FMLInitializationEvent event) {
    LOGGER.info("Initializing " + MOD_NAME);

    EntityRegistry.registerGlobalEntityID(RegularHamster.class, "regularHamster", m_regularHamsterId.getInt());
  }
}
