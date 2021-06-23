package bwm.items;

import java.util.List;
import java.util.Locale;

import javax.annotation.Nullable;

import com.mrcrayfish.guns.common.Gun;
import com.mrcrayfish.guns.item.GunItem;
import com.mrcrayfish.guns.util.GunEnchantmentHelper;
import com.mrcrayfish.guns.util.GunModifierHelper;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.KeybindTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.registries.ForgeRegistries;

/*
 * The original GunItem.class was so good, I made a second one.
 * This class extends the regular GunItem class so we can add our own special properties to our guns.
 */
public class BWMGunItem extends GunItem{

	public BWMGunItem(Properties properties) {
		
		super(properties);
		
	}
	
	/*
	 * This block of code is copied from the original GunItem class but adds info about the fire mode of the gun.
	 */
	@Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flag)
    {
        Gun modifiedGun = this.getModifiedGun(stack);

        Item ammo = ForgeRegistries.ITEMS.getValue(modifiedGun.getProjectile().getItem());
        if(ammo != null)
        {
            tooltip.add(new TranslationTextComponent("info.cgm.ammo_type", new TranslationTextComponent(ammo.getTranslationKey()).mergeStyle(TextFormatting.WHITE)).mergeStyle(TextFormatting.GRAY));
        }

        String additionalDamageText = "";
        CompoundNBT tagCompound = stack.getTag();
        if(tagCompound != null)
        {
            if(tagCompound.contains("AdditionalDamage", Constants.NBT.TAG_ANY_NUMERIC))
            {
                float additionalDamage = tagCompound.getFloat("AdditionalDamage");
                additionalDamage += GunModifierHelper.getAdditionalDamage(stack);

                if(additionalDamage > 0)
                {
                    additionalDamageText = TextFormatting.GREEN + " +" + ItemStack.DECIMALFORMAT.format(additionalDamage);
                }
                else if(additionalDamage < 0)
                {
                    additionalDamageText = TextFormatting.RED + " " + ItemStack.DECIMALFORMAT.format(additionalDamage);
                }
            }
        }

        float damage = modifiedGun.getProjectile().getDamage();
        damage = GunModifierHelper.getModifiedProjectileDamage(stack, damage);
        damage = GunEnchantmentHelper.getAcceleratorDamage(stack, damage);
        tooltip.add(new TranslationTextComponent("info.cgm.damage", TextFormatting.WHITE + ItemStack.DECIMALFORMAT.format(damage) + additionalDamageText).mergeStyle(TextFormatting.GRAY));

        if(tagCompound != null)
        {
            if(tagCompound.getBoolean("IgnoreAmmo"))
            {
                tooltip.add(new TranslationTextComponent("info.cgm.ignore_ammo").mergeStyle(TextFormatting.AQUA));
            }
            else
            {
                int ammoCount = tagCompound.getInt("AmmoCount");
                tooltip.add(new TranslationTextComponent("info.cgm.ammo", TextFormatting.WHITE.toString() + ammoCount + "/" + GunEnchantmentHelper.getAmmoCapacity(stack, modifiedGun)).mergeStyle(TextFormatting.GRAY));
            }
        }
        /*
         * This little block of code is the only addition.
         * It determines the fire mode of the gun and displays it with the rest of the tooltip.
         */
        boolean auto = modifiedGun.getGeneral().isAuto();
        if(GunEnchantmentHelper.getAmmoCapacity(stack, modifiedGun) == 1) {
        	
        	tooltip.add(new TranslationTextComponent("info.bwm.fire_mode", new TranslationTextComponent("info.bwm.single").mergeStyle(TextFormatting.WHITE)).mergeStyle(TextFormatting.GRAY));
        	
        }
        
        if(auto == true && GunEnchantmentHelper.getAmmoCapacity(stack, modifiedGun) > 1) {
        	
        	tooltip.add(new TranslationTextComponent("info.bwm.fire_mode", new TranslationTextComponent("info.bwm.auto").mergeStyle(TextFormatting.WHITE)).mergeStyle(TextFormatting.GRAY));
        	
        }
        else if (auto == false && GunEnchantmentHelper.getAmmoCapacity(stack, modifiedGun) > 1){
        	
        	tooltip.add(new TranslationTextComponent("info.bwm.fire_mode", new TranslationTextComponent("info.bwm.semi").mergeStyle(TextFormatting.WHITE)).mergeStyle(TextFormatting.GRAY));
        	
        }
        //End here

        tooltip.add(new TranslationTextComponent("info.cgm.attachment_help", new KeybindTextComponent("key.cgm.attachments").getString().toUpperCase(Locale.ENGLISH)).mergeStyle(TextFormatting.YELLOW));
    }
	
	/*
	 * This block of code overrides the enchantment glint.
	 */
	@Override
	public boolean hasEffect(ItemStack stack) {
		
        return false;
        
    }

}