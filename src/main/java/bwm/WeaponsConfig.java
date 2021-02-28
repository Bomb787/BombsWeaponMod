package bwm;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraftforge.common.ForgeConfigSpec;

public class WeaponsConfig {
	
	//Client options
	public static class Client{
		
		//None yet, just here if I ever do add client stuff
		
	}
	
	//Common options
	public static class Common{
		
		public final Ores ores;
		
		public Common(ForgeConfigSpec.Builder builder) {
			
            builder.push("common"); {
            	
                this.ores = new Ores(builder);
                
            }
            
            builder.pop();
            
        }
		
	}
	
	public static class Ores{
		
		public final ForgeConfigSpec.BooleanValue generateBauxite;
		public final ForgeConfigSpec.IntValue maxBauxiteVein;
		public final ForgeConfigSpec.IntValue minBauxiteY;
		public final ForgeConfigSpec.IntValue maxBauxiteY;
		public final ForgeConfigSpec.IntValue maxBauxiteChunk;
		
		public Ores(ForgeConfigSpec.Builder builder) {
			
            builder.comment("Properties relating to ores").push("ores"); {
            	
            	this.generateBauxite = builder.comment("Should Bauxite Ore be generated? Turn off if there is another mod already generating it. This is the same thing as aluminum ore.").define("generateBauxite", true);
                this.maxBauxiteVein = builder.comment("Maximum size of a single vein of Bauxite Ore").defineInRange("maxBauxiteVeinn", 6, 0, Integer.MAX_VALUE);
                this.minBauxiteY = builder.comment("The minimum Y level where Bauxite Ore will spawn, must be less than maximum").defineInRange("minBauxiteY", 32, 0, Integer.MAX_VALUE);
                this.maxBauxiteY = builder.comment("The maxiumum Y level where Bauxite Ore will spawn, must be more than minimum").defineInRange("maxBauxiteY", 56, 0, Integer.MAX_VALUE);
                this.maxBauxiteChunk = builder.comment("The maximum amount of Bauxite Ore in a chunk").defineInRange("maxBauxiteChunk", 18, 0, Integer.MAX_VALUE);
                
            }
            
            builder.pop();
            
        }
		
	}
	
	//static final ForgeConfigSpec clientSpec;
    //public static final WeaponsConfig.Client CLIENT;

    static final ForgeConfigSpec commonSpec;
    public static final Common COMMON;
    
    static {
    	
        //final Pair<Client, ForgeConfigSpec> clientSpecPair = new ForgeConfigSpec.Builder().configure(WeaponsConfig.Client::new);
        //clientSpec = clientSpecPair.getRight();
        //CLIENT = clientSpecPair.getLeft();

        final Pair<Common, ForgeConfigSpec> commonSpecPair = new ForgeConfigSpec.Builder().configure(Common::new);
        commonSpec = commonSpecPair.getRight();
        COMMON = commonSpecPair.getLeft();
        
    }
    
    public static void saveConfig() {
    	
        //clientSpec.save();
    	commonSpec.save();
        
    }

}
