package jmanz7.oreandfarming.config;

import java.io.File;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class Config 
{
	
	
	private static final ForgeConfigSpec.Builder server_builder = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec server_config;

	private static final ForgeConfigSpec.Builder client_builder = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec client_config;
	
	//public static final ForgeConfigSpec.IntValue exp_drop_crop;
	
	static
	{
		server_config = server_builder.build();
		client_config = client_builder.build();
	}
	
	public static void loadConfig(ForgeConfigSpec config, String path)
	{
		//OreandFarmingMain.logger.info("Loading Config");
		final CommentedFileConfig file = CommentedFileConfig.builder(new File(path)).sync().autosave().writingMode(WritingMode.REPLACE).build();
		file.load();
		config.setConfig(file);
	}
	
	
}
