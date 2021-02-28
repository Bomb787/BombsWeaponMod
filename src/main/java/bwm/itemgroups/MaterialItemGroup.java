package bwm.itemgroups;

import bwm.core.init.ItemInit;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class MaterialItemGroup extends ItemGroup{
	
	public MaterialItemGroup() {
		
		super("material");
		
	}

	@Override
	public ItemStack createIcon() {
		
		return new ItemStack(ItemInit.ALUMINIUM_INGOT.get());
		
	}

}
