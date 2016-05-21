package leordas.slimetector.proxy;

import leordas.slimetector.RegistryManager;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {
	
	
	public void preInit(FMLPreInitializationEvent event){
		RegistryManager.init();
	}
	
	public void init(FMLInitializationEvent event){
		RegistryManager.registerRecipes();
	}
	
	public void postInit(FMLPostInitializationEvent event){
		
	}
	
}
