package plugin.divinity2;

import org.bukkit.plugin.java.JavaPlugin;

public final class Divinity extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("GodsPlugin abilitato!");
        this.getCommand("offer").setExecutor(new ComandoOfferte());
    }

    @Override
    public void onDisable() {
        getLogger().info("GodsPlugin disabilitato!");
    }
}
