package am.noah.benchmark.bungeecord;

import am.noah.benchmark.bungeecord.bridge.BungeecordBridge;
import am.noah.benchmark.bungeecord.listener.JoinListener;
import net.md_5.bungee.api.plugin.Plugin;

public class BenchmarkPlugin extends Plugin {

    BungeecordBridge bungeecordBridge;

    /*
     * These are our Getters.
     * This allows us to access the information saved within this class in an easy and neat manner.
     * I could just use Lombok, but I am not a fan of Lombok.
     */

    /**
     * Return the BungeecordBridge object stored within this class.
     */
    public BungeecordBridge getBungeecordBridge() {
        return bungeecordBridge;
    }

    /*
     * The following are important events which will be called by the Bungeecord Plugin class.
     */

    /**
     * This method is called when the plugin has been enabled.
     * This allows us to start everything we need to start.
     */
    @Override
    public void onEnable() {
        getProxy().getPluginManager().registerListener(this, new JoinListener(this));

        bungeecordBridge = new BungeecordBridge(this);

        getLogger().info("Note: Bungeecord may come with plugins preinstalled that cannot be removed.");
        getLogger().info("This proxy has " + getProxy().getPluginManager().getPlugins().size() + " plugins installed.");
    }

    /**
     * This method is called when the proxy is stopping.
     * This allows us to safely stop ongoing processes instead of them being stopped abruptly.
     */
    @Override
    public void onDisable() {
        bungeecordBridge.stopCore();
        bungeecordBridge = null;
    }
}
