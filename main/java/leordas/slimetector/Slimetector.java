package leordas.slimetector;

import leordas.slimetector.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid =Slimetector.MODID, name = Slimetector.NAME, version = Slimetector.VERSION)
public class Slimetector {

	public static final String NAME = "Slimetector";
    public static final String MODID = "slimetector";
    public static final String VERSION = "1.0";
    
    @SidedProxy(clientSide = "leordas.slimetector.proxy.ClientProxy", serverSide = "leordas.slimetector.proxy.ServerProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
    	proxy.preInit(event);
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event){
    	proxy.init(event);
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event){
    	proxy.postInit(event);
    }
	
}
