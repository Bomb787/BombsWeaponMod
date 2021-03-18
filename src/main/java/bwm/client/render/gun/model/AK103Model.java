package bwm.client.render.gun.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mrcrayfish.guns.client.render.gun.IOverrideModel;
import com.mrcrayfish.guns.client.util.RenderUtil;

import bwm.client.SpecialModels;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.CooldownTracker;

/*
 * Since we want to have an animation for the bolt of the gun, we will be overriding the standard model rendering.
 */
public class AK103Model implements IOverrideModel{
	
	@SuppressWarnings("resource")
	@Override
	public void render(float partialTicks, TransformType transformType, ItemStack stack, ItemStack parent, LivingEntity entity, MatrixStack matrixStack, IRenderTypeBuffer renderTypeBuffer, int light, int overlay) {
		
		//Renders the static parts of the model, the magazine is separate from the base for possible future use.
		RenderUtil.renderModel(SpecialModels.AK103BASE.getModel(), stack, matrixStack, renderTypeBuffer, light, overlay);
		RenderUtil.renderModel(SpecialModels.AK103MAGAZINE.getModel(), stack, matrixStack, renderTypeBuffer, light, overlay);
		
		if(entity.equals(Minecraft.getInstance().player)) {
			
			//Always push.
            matrixStack.push();
            //Don't touch this, it's better to use the display options in Blockbench.
            matrixStack.translate(0, -5.8 * 0.0625, 0);
            //Gets the cooldown tracker for the item. Items like swords and enderpearls also have this.
            CooldownTracker tracker = Minecraft.getInstance().player.getCooldownTracker();
            float cooldown = tracker.getCooldown(stack.getItem(), Minecraft.getInstance().getRenderPartialTicks());
            cooldown = (float) easeOutExpo(cooldown);
            /**
             * We are moving whatever part is moving.
             * X,Y,Z, use Z for moving back and forth.
             */
            matrixStack.translate(0, 0, cooldown/3);
            matrixStack.translate(0, 5.8 * 0.0625, 0);
            //Renders the moving part of the gun.
            RenderUtil.renderModel(SpecialModels.AK103BOLT.getModel(), stack, matrixStack, renderTypeBuffer, light, overlay);
            //Always pop
            matrixStack.pop();
            
        }
		
	}
	
	/**
     * Easing function based on code from https://easings.net/#easeOutQuart
     */
	private double easeOutExpo(double x) {
		
		return x == 1 ? 1 : 1 - Math.pow(2, -10 * x);
        
    }

}