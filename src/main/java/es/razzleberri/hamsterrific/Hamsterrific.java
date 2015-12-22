package es.razzleberri.hamsterrific;

import es.razzleberri.hamsterrific.proxy.Common;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = Hamsterrific.MOD_ID, version = Hamsterrific.MOD_VERSION, name = Hamsterrific.MOD_NAME)
public class Hamsterrific {

  public static final String MOD_ID = "es.razzleberri.hamsterrific";
  public static final String MOD_VERSION = "0.3";
  public static final String MOD_NAME = "Hamsterrific";

  public static final Logger LOGGER = FMLLog.getLogger();

  @Instance
  public static Hamsterrific instance = new Hamsterrific();

  @SidedProxy(clientSide = MOD_ID + ".proxy.Client", serverSide = MOD_ID + ".proxy.Server", modId = MOD_ID)
  public static Common proxy;

  @EventHandler
  public void onPreInit(FMLPreInitializationEvent event) {
    proxy.onPreInit(event);
  }

  @EventHandler
  public void onInit(FMLInitializationEvent event) {
    proxy.onInit(event);
  }

  @EventHandler
  public void onStopping(FMLServerStoppingEvent event) {
    proxy.onStopping(event);
  }
}
