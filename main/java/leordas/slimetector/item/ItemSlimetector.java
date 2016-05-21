package leordas.slimetector.item;

import java.util.Random;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemSlimetector extends Item {
	
	Random rnd = new Random();
	
	public ItemSlimetector(){
		super();
		setUnlocalizedName("slimetector");
		setCreativeTab(CreativeTabs.tabTools);
	}
	
	@SideOnly(Side.CLIENT)
	public void initModel(){
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(),"inventory"));
	}
	
	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
		
		
		return EnumActionResult.SUCCESS;
	}
	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		
		rnd.setSeed(worldIn.getSeed() +
                (long) (entityIn.chunkCoordX * entityIn.chunkCoordX * 0x4c1906) +
                (long) (entityIn.chunkCoordX * 0x5ac0db) + 
                (long) (entityIn.chunkCoordZ * entityIn.chunkCoordZ) * 0x4307a7L +
                (long) (entityIn.chunkCoordZ * 0x5f24f) ^ 0x3ad8025f);
		
		if(!stack.hasTagCompound()){
			stack.setTagCompound(new NBTTagCompound());
			stack.getTagCompound().setBoolean("isChunkSlimy", (rnd.nextInt(10) == 0));
			stack.getTagCompound().setInteger("lastChunkX", entityIn.chunkCoordX);
			stack.getTagCompound().setInteger("lastChunkZ", entityIn.chunkCoordZ);
		}		
		
		if(stack.getTagCompound().getInteger("lastChunkX") == entityIn.chunkCoordX & stack.getTagCompound().getInteger("lastChunkZ") == entityIn.chunkCoordZ){
			;
		}else{
			stack.getTagCompound().setBoolean("isChunkSlimy", (rnd.nextInt(10) == 0));
			stack.getTagCompound().setInteger("lastChunkX", entityIn.chunkCoordX);
			stack.getTagCompound().setInteger("lastChunkZ", entityIn.chunkCoordZ);
		}
		
	}
	
	public static class ColorHandler implements IItemColor {
		
		public ColorHandler(){
			//
		}
		
		@Override
		public int getColorFromItemstack(ItemStack stack, int layer) {
			if (stack.hasTagCompound()){
				if(layer == 1){
					
					if(stack.getTagCompound().getBoolean("isChunkSlimy")){
						return 0x75B71E;
					}else{
						return 0x253C08;
					}
				}
			}
			return 0xFFFFFF;
		}
	}
	
}
