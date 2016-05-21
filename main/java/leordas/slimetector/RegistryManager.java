package leordas.slimetector;

import leordas.slimetector.item.ItemSlimetector;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RegistryManager {
	
	public static Item slimetector;
	
	public static void init(){
		GameRegistry.registerItem(slimetector = new ItemSlimetector(),"slimetector");
	}
	
	public static void registerRecipes(){
		GameRegistry.addRecipe(new ItemStack(slimetector)," LE"," IL","I  ",'L',new ItemStack(Items.dye,1,4),'E',Items.emerald,'I',Items.iron_ingot);
	}
	
	public static void registerItemRenderers(){
		((ItemSlimetector)slimetector).initModel();
	}
	
	public static void registerColorHandlers(){
		Minecraft.getMinecraft().getItemColors().registerItemColorHandler(new ItemSlimetector.ColorHandler(), slimetector);
	}
	
}
