/*package bwm.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;

import bwm.common.entities.BackblastEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class BackblastEntityRenderer extends EntityRenderer<BackblastEntity>{

	protected BackblastEntityRenderer(EntityRendererManager renderManager) {
		
		super(renderManager);
		
	}
	
	//No model, even with a model this can just return null.
	@Override
	public ResourceLocation getEntityTexture(BackblastEntity entity) {
		
		return null;
		
	}
	
	@Override
	public void render(BackblastEntity entity, float entityYaw, float partialTicks, MatrixStack matrices, IRenderTypeBuffer buffer, int light) {
		
		//Since backblast is just air pressure, there is really no need to render it.
		
		if(!entity.getProjectile().isVisible() || entity.ticksExisted <= 1) {
			
            return;
            
        }
		
	}

}
*/