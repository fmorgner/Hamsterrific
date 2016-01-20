package es.razzleberri.hamsterrific.proxy;

import es.razzleberri.hamsterrific.Hamsterrific;
import es.razzleberri.hamsterrific.entity.EntityRegularHamster;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import static es.razzleberri.hamsterrific.constants.Configuration.*;
import static es.razzleberri.hamsterrific.constants.Names.NAME_REGULAR_HAMSTER;

public class Common {

  protected final Hamsterrific m_modInstance = Hamsterrific.instance;

  protected Configuration m_configuration;
  protected Property m_regularHamsterId;

  public void onPreInit(FMLPreInitializationEvent event) {
    m_configuration = new Configuration(event.getSuggestedConfigurationFile());
    m_configuration.load();

    m_regularHamsterId = m_configuration.get(CATEGORY_ENTITIES, PROPERTY_REGULAR_HAMSTER_ID, VALUE_DEFAULT_REGULAR_HAMSTER_ID);
  }

  public void onInit(FMLInitializationEvent event) {
    m_modInstance.LOGGER.debug("Registering \"" + NAME_REGULAR_HAMSTER + "\"");
    EntityRegistry.registerModEntity(EntityRegularHamster.class, NAME_REGULAR_HAMSTER, m_regularHamsterId.getInt(),
      Hamsterrific.instance, 100, 1, false);
  }

  public void onStopping(FMLServerStoppingEvent event) {
    m_configuration.save();
  }

}
