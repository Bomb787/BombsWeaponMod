package bwm.itemgroups;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class BulletItemGroup extends ItemGroup{

	public BulletItemGroup() {
		
		super("bullet");
		
	}

	@Override
	public ItemStack createIcon() {
		
		return new ItemStack(Items.ARROW);
		
	}
	
	@Override
	public boolean hasSearchBar() {
		
		return true;
		
	}
	
	@Override
	public String getBackgroundImageName(){
		
		return ("item_search.png");
		
	}

}