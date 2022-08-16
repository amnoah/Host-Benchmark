package am.noah.benchmark.spigot;

import am.noah.benchmark.spigot.bridge.SpigotBridge;
import am.noah.benchmark.spigot.listener.JoinListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class BenchmarkPlugin extends JavaPlugin {

    SpigotBridge spigotBridge;

    /*
     * These are our Getters.
     * This allows us to access the information saved within this class in an easy and neat manner.
     * I could just use Lombok, but I am not a fan of Lombok.
     */

    /**
     * Return the SpigotBridge object stored within this class.
     */
    public SpigotBridge getSpigotBridge() {
        return spigotBridge;
    }

    /*
     * The following are important events which will be called by the Bukkit JavaPlugin class.
     */

    /**
     * This method is called when the plugin has been enabled.
     * This allows us to start everything we need to start.
     */
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new JoinListener(this), this);

        spigotBridge = new SpigotBridge(this);

        spigotBridge.pluginListSize(Bukkit.getPluginManager().getPlugins().length);
    }

    /**
     * This method is called when the server is stopping/reloading.
     * This allows us to safely stop ongoing processes instead of them being stopped abruptly.
     */
    @Override
    public void onDisable() {
        spigotBridge.stopCore();
        spigotBridge = null;
    }
}
