package am.noah.benchmark.velocity;

import am.noah.benchmark.velocity.bridge.VelocityBridge;
import am.noah.benchmark.velocity.listener.JoinListener;
import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.event.proxy.ProxyShutdownEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;
import org.slf4j.Logger;

@Plugin(id = "benchmark", name = "Benchmark", version = "0.3", description = "A benchmark plugin for Minecraft.", authors = {"am noah"})
public class BenchmarkPlugin {

    private final Logger logger;
    private final ProxyServer server;

    VelocityBridge velocityBridge;

    /**
     * Initialize the BenchmarkPlugin object, also injecting into the ProxyServer and Logger objects.
     */
    @Inject
    public BenchmarkPlugin(ProxyServer proxyServer, Logger logger) {
        this.server = proxyServer;
        this.logger = logger;
    }

    /*
     * These are our Getters.
     * This allows us to access the information saved within this class in an easy and neat manner.
     * I could just use Lombok, but I am not a fan of Lombok.
     */

    /**
     * Return the Logger object stored within this class.
     */
    public Logger getLogger() {
        return logger;
    }

    /**
     * Return the ProxyServer object stored within this class.
     */
    public ProxyServer getServer() {
        return server;
    }

    /**
     * Return the VelocityBridge object stored within this class.
     */
    public VelocityBridge getVelocityBridge() {
        return velocityBridge;
    }

    /*
     * The following are important events which will be called by Velocity.
     */

    /**
     * This method is called when the plugin has been enabled.
     * This allows us to start everything we need to start.
     */
    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        server.getEventManager().register(this, new JoinListener(this));

        velocityBridge = new VelocityBridge(this);

        velocityBridge.pluginListSize(server.getPluginManager().getPlugins().size());
    }

    /**
     * This method is called when the proxy is stopping.
     * This allows us to safely stop ongoing processes instead of them being stopped abruptly.
     */
    @Subscribe
    public void onProxyShutdown(ProxyShutdownEvent event) {
        velocityBridge.stopCore();
        velocityBridge = null;
    }
}
