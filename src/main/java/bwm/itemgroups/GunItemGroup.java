package bwm.itemgroups;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class GunItemGroup extends ItemGroup{
	
	public GunItemGroup() {
		
		super("gun");
		
	}

	@Override
	public ItemStack createIcon() {
		
		return new ItemStack(Items.BOW);
		
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