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
 * Since we want to have an animation for the barrel of the gun, we will be overriding the standard model rendering.
 * This is basically just the assault rifle by MrCrayfish with a few texturing and model differences.
 */
public class GaussRifleModel implements IOverrideModel{
	
	@SuppressWarnings("resource")
	@Override
	public void render(float partialTicks, TransformType transformType, ItemStack stack, ItemStack parent, LivingEntity entity, MatrixStack matrixStack, IRenderTypeBuffer renderTypeBuffer, int light, int overlay) {
		
		//Renders the static parts of the model.
		RenderUtil.renderModel(SpecialModels.GAUSSRIFLEBASE.getModel(), stack, matrixStack, renderTypeBuffer, light, overlay);
		
		if(entity.equals(Minecraft.getInstance().player)) {
			
			//Always push.
            matrixStack.push();
            //Don't touch this, it's better to use the display options in Blockbench.
            matrixStack.translate(0, -5.8 * 0.0625, 0);
            //Gets the cooldown tracker for the item. Items like swords and enderpearls also have this.
            CooldownTracker tracker = Minecraft.getInstance().player.getCooldownTracker();
            float cooldown = tracker.getCooldown(stack.getItem(), Minecraft.getInstance().getRenderPartialTicks());
            cooldown = (float) easeOutQuart(cooldown);
            /**
             * We are moving whatever part is moving.
             * X,Y,Z, use Z for moving back and forth.
             */
            matrixStack.translate(0, 0, cooldown/6.5);
            matrixStack.translate(0, 5.8 * 0.0625, 0);
            //Renders the moving part of the gun.
            RenderUtil.renderModel(SpecialModels.GAUSSRIFLEBARREL.getModel(), stack, matrixStack, renderTypeBuffer, light, overlay);
            //Always pop
            matrixStack.pop();
        }
		
	}
	
	/**
     * Easing function based on code from https://easings.net/#easeOutQuart
     */
	private double easeOutQuart(double x) {
		
		return 1 - Math.pow(1 - x, 4);
        
    }

}
