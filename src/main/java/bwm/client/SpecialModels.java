package bwm.client;

import bwm.WeaponsMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.eventbus.api.SubscribeEvent;

/**
 * Author: Original by MrCrayfish, this one by Bomb787
 */
public enum SpecialModels {
	
	GLOCK17SLIDE("glock17_slide"),
	GLOCK17BASE("glock17_base"),
	GLOCK17MAGAZINE("glock17_magazine");
	
	/**
     * The location of an item model in the [MOD_ID]/models/moving/[NAME] folder
     */
	private ResourceLocation modelLocation;
	
	/**
     * Determines if the model should be loaded as a special model.
     */
	private boolean specialModel;
	
	/**
     * Cached model
     */
	@OnlyIn(Dist.CLIENT)
    private IBakedModel cachedModel;
	
	/**
     * Sets the model's location
     *
     * @param modelName name of the model file
     */
	SpecialModels(String modelName){
		
		this(new ResourceLocation(WeaponsMod.MOD_ID, "special/" + modelName), true);
		
	}
	
	/**
     * Sets the model's location
     *
     * @param resource name of the model file
     * @param specialModel if the model is a special model
     */
	SpecialModels(ResourceLocation resourceLocation, boolean specialModel) {
		 
		 this.modelLocation = resourceLocation;
		 this.specialModel = specialModel;
		 
	}
	
	/**
     * Gets the model
     *
     * @return isolated model
     */
	@OnlyIn(Dist.CLIENT)
	public IBakedModel getModel() {
		 
		if(this.cachedModel == null) {
	        	
			IBakedModel model = Minecraft.getInstance().getModelManager().getModel(this.modelLocation);
			 
			if(model == Minecraft.getInstance().getModelManager().getMissingModel()) {
	            	
				return model;
	                
			} this.cachedModel = model;
			 
			 
		} return this.cachedModel;
	     
	}
	 
	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public static void register(ModelRegistryEvent event) {
		 
		for(SpecialModels model : values()) {
	        	
			if(model.specialModel) {
	            	
				ModelLoader.addSpecialModel(model.modelLocation);
	                
			}
	            
		}
	        
	}

}