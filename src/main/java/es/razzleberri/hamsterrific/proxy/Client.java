package es.razzleberri.hamsterrific.proxy;

import es.razzleberri.hamsterrific.entity.EntityHamster;
import es.razzleberri.hamsterrific.model.ModelHamster;
import es.razzleberri.hamsterrific.renderer.RenderHamster;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public class Client extends Common {

  @Override
  public void onInit(FMLInitializationEvent event) {
    super.onInit(event);

    RenderingRegistry.registerEntityRenderingHandler(EntityHamster.class, new RenderHamster(new ModelHamster(), .5f));
    }

  }
