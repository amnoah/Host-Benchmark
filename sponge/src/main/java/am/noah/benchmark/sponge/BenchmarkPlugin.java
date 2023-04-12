package am.noah.benchmark.sponge;

import am.noah.benchmark.sponge.bridge.SpongeBridge;
import com.google.inject.Inject;
import org.apache.logging.log4j.Logger;
import org.spongepowered.api.Server;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.lifecycle.*;
import org.spongepowered.api.event.network.ServerSideConnectionEvent;
import org.spongepowered.plugin.PluginContainer;
import org.spongepowered.plugin.builtin.jvm.Plugin;

/**
 * The main class of your Sponge plugin.
 *
 * <p>All methods are optional -- some common event registrations are included as a jumping-off point.</p>
 */
@Plugin("BenchmarkPlugin")
public class BenchmarkPlugin {

    @SuppressWarnings("FieldCanBeLocal")
    private final PluginContainer container;
    private final Logger logger;

    private SpongeBridge spongeBridge;

    @Inject
    BenchmarkPlugin(final PluginContainer container, final Logger logger) {
        this.container = container;
        this.logger = logger;
    }

    /**
     * This method is called when the plugin has been enabled.
     * This allows us to start everything we need to start.
     *
     * Sponge itself contains 4 "plugins", so those are removed.
     */
    @Listener
    public void onServerStarting(final StartedEngineEvent<Server> event) {
        // Any setup per-game instance. This can run multiple times when
        // using the integrated (singleplayer) server.
        this.spongeBridge = new SpongeBridge(this);
        this.spongeBridge.pluginListSize(Sponge.pluginManager().plugins().size() - 4);
    }

    /**
     * This method is called when the server is stopping/reloading.
     * This allows us to safely stop ongoing processes instead of them being stopped abruptly.
     */
    @Listener
    public void onServerStopping(final StoppingEngineEvent<Server> event) {
        // Any tear down per-game instance. This can run multiple times when
        // using the integrated (singleplayer) server.
        this.spongeBridge.stopCore();
        this.spongeBridge = null;
    }

    /**
     * A player joining the server can compromise test results, so we should alert the Core of it happening.
     */
    @Listener
    public void onPlayerJoin(final ServerSideConnectionEvent.Join event) {
        this.spongeBridge.joinEvent();
    }

    /**
     * Returns the plugin's logger.
     */
    public Logger getLogger() {
        return this.logger;
    }
}
