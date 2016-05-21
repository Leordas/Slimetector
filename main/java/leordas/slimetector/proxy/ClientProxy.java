package leordas.slimetector.proxy;

import leordas.slimetector.RegistryManager;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void preInit(FMLPreInitializationEvent event){
		super.preInit(event);
		RegistryManager.registerItemRenderers();
	}
	
	@Override
	public void init(FMLInitializationEvent event){
		super.init(event);
		
		RegistryManager.registerColorHandlers();
	}
	
	@Override
	public void postInit(FMLPostInitializationEvent event){
		super.postInit(event);
	}
}
