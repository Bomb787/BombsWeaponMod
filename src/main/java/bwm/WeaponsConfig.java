package bwm;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraftforge.common.ForgeConfigSpec;

/*
 * This class creates the config file for the mod.
 * Currently, the only options are for the generation of bauxite ore.
 * 
 */
public class WeaponsConfig {
	
	//Common options
	public static class Common{
		
		//Initiates the Ores section.
		public final Ores ores;
		
		//Constructor for the Common section.
		public Common(ForgeConfigSpec.Builder builder) {
			
			//Pushing the section to the config with the title of "common."
            builder.push("common"); {
            	
            	//Calls the Ore section below
                this.ores = new Ores(builder);
                
            }
            //Always remember to pop this section.
            builder.pop();
            
        }
		
	}
	
	//
	public static class Ores{
		
		//Initiates the values
		public final ForgeConfigSpec.BooleanValue generateBauxite;
		public final ForgeConfigSpec.IntValue maxBauxiteVein;
		public final ForgeConfigSpec.IntValue minBauxiteY;
		public final ForgeConfigSpec.IntValue maxBauxiteY;
		public final ForgeConfigSpec.IntValue maxBauxiteChunk;
		
		public Ores(ForgeConfigSpec.Builder builder) {
			
			//Adds a comment to the config file that tells the player what this section is for, while also pushing the section to the config.
            builder.comment("Properties relating to ores").push("ores"); {
            	
            	//Highly recommended to have a comment so the player knows what each line is for. A default value is also defined as well as the minimum and maximum values.
            	this.generateBauxite = builder.comment("Should Bauxite Ore be generated? Turn off if there is another mod already generating it. This is the same thing as aluminum ore.").define("generateBauxite", true);
                this.maxBauxiteVein = builder.comment("Maximum size of a single vein of Bauxite Ore").defineInRange("maxBauxiteVeinn", 6, 0, Integer.MAX_VALUE);
                this.minBauxiteY = builder.comment("The minimum Y level where Bauxite Ore will spawn, must be less than maximum").defineInRange("minBauxiteY", 32, 0, Integer.MAX_VALUE);
                this.maxBauxiteY = builder.comment("The maxiumum Y level where Bauxite Ore will spawn, must be more than minimum").defineInRange("maxBauxiteY", 56, 0, Integer.MAX_VALUE);
                this.maxBauxiteChunk = builder.comment("The maximum amount of Bauxite Ore in a chunk").defineInRange("maxBauxiteChunk", 18, 0, Integer.MAX_VALUE);
                
            }
            //Always remember to pop this section.
            builder.pop();
            
        }
		
	}

	//We create these variables so we are able to call the values in the config from other parts of our code.
    static final ForgeConfigSpec commonSpec;
    public static final Common COMMON;
    
    static {

        final Pair<Common, ForgeConfigSpec> commonSpecPair = new ForgeConfigSpec.Builder().configure(Common::new);
        commonSpec = commonSpecPair.getRight();
        COMMON = commonSpecPair.getLeft();
        
    }
    
    public static void saveConfig() {
    	
    	commonSpec.save();
        
    }

}
