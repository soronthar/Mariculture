package mariculture.plugins;

import mariculture.plugins.Plugins.Plugin;
import cpw.mods.fml.common.event.FMLInterModComms;

public class PluginWaila extends Plugin {
	@Override
	public void preInit() {
		return;
	}

	@Override
	public void init() {
		FMLInterModComms.sendMessage("Waila", "register", "mariculture.plugins.waila.VatDataProvider.register");
	}

	@Override
	public void postInit() {
		return;
	}
}