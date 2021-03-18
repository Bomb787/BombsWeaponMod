package bwm.core.init;

import bwm.WeaponsMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * This class is where all of the mod's blocks are registered
 * Author: Bomb787
 */
public class BlockInit {
	
	/*
     * This creates a Deferred Register where all of the blocks will be registered
     * This is called and added to the event bus in the main mod file.
     */
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			WeaponsMod.MOD_ID);
	
	public static final RegistryObject<Block> BAUXITE_ORE = BLOCKS.register("bauxite_ore",
			() -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.GRAY)
			.hardnessAndResistance(3f, 3f)
			.harvestTool(ToolType.PICKAXE)
			.harvestLevel(1)
			.sound(SoundType.STONE)
			.setRequiresTool()));
	
	public static final RegistryObject<Block> ALUMINIUM_BLOCK = BLOCKS.register("aluminium_block",
			() -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.WOOL)
			.hardnessAndResistance(5f, 6f)
			.harvestTool(ToolType.PICKAXE)
			.harvestLevel(1)
			.sound(SoundType.METAL)
			.setRequiresTool()));
	
	public static final RegistryObject<Block> STEEL_BLOCK = BLOCKS.register("steel_block",
			() -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.LIGHT_GRAY)
			.hardnessAndResistance(7f, 9f)
			.harvestTool(ToolType.PICKAXE)
			.harvestLevel(2)
			.sound(SoundType.METAL)
			.setRequiresTool()));
	
	public static final RegistryObject<Block> POLYMER_BLOCK = BLOCKS.register("polymer_block",
			() -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK)
			.hardnessAndResistance(2f, 1f)
			.sound(SoundType.STONE)));

}
