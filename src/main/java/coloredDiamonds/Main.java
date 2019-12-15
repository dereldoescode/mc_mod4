package coloredDiamonds;

import coloredDiamonds.init.ModRecipes;
import coloredDiamonds.proxy.CommonProxy;
import coloredDiamonds.util.Reference;
import coloredDiamonds.world.ModWorldGen;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version =Reference.VERSION)
public class Main {
@Instance
public static Main instance;
@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
public static CommonProxy proxy;
@EventHandler
public static void PreInit(FMLPreInitializationEvent event) {
	GameRegistry.registerWorldGenerator(new ModWorldGen(), 3) ;
	NetworkRegistry.INSTANCE.registerGuiHandler(coloredDiamonds.Main.class , new ModGuiHandler());
}
@EventHandler
public static void init(FMLInitializationEvent event) {
	ModRecipes.init();
	
}
@EventHandler
public static void PostInit(FMLPostInitializationEvent event) {
}
}
