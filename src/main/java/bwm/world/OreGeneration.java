package bwm.world;

import bwm.core.init.BlockInit;
import bwm.WeaponsConfig;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;

/*
 * This class tells the mod how to generate the ores that will be added.
 * Author: Bomb787
 */
public class OreGeneration {
	
	public static void generateOres(final BiomeLoadingEvent event) {
		
		//Initiates the values and gets them from our config file.
		final boolean generateBauxite = WeaponsConfig.COMMON.ores.generateBauxite.get();
		final int maxBauxiteVein = WeaponsConfig.COMMON.ores.maxBauxiteVein.get();
		final int minBauxiteY = WeaponsConfig.COMMON.ores.minBauxiteY.get();
		final int maxBauxiteY = WeaponsConfig.COMMON.ores.maxBauxiteY.get();
		final int maxBauxiteChunk = WeaponsConfig.COMMON.ores.maxBauxiteChunk.get();
		
		//Makes sure that the ore only generates in the Overworld.
		if(!(event.getCategory().equals(Biome.Category.NETHER)) || (event.getCategory().equals(Biome.Category.THEEND))) {
			
			//Makes sure that the config has bauxite ore enabled.
			if(generateBauxite == true)
			//Default max vein size of 6, minimum Y of 32, max of 56, at most 18 per chunk
			generateOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, 
				BlockInit.BAUXITE_ORE.get().getDefaultState(), maxBauxiteVein, minBauxiteY, maxBauxiteY, maxBauxiteChunk);
				//System.out.println("Bomb's Weapons Mod generating Bauxite Ore, max vein size: " + maxBauxiteVein + ", min Y: " + minBauxiteY + ", max Y: " + maxBauxiteY + ", max chunk amount: " + maxBauxiteChunk);
			
		}
		
	}
	
	//A method to help us generate the ores, it's much easier to call it and define the values instead of typing out a long line of code every time we want to generate a new ore.
	private static void generateOre(BiomeGenerationSettingsBuilder settings, RuleTest fillerType, BlockState state, int veinSize, int minHeight, int maxHeight, int count) {
		
		settings.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, 
				Feature.ORE.withConfiguration(new OreFeatureConfig(fillerType, state, veinSize))
					.withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(minHeight, 0, maxHeight)))
					.square().func_242731_b(count));
		
	}

}
