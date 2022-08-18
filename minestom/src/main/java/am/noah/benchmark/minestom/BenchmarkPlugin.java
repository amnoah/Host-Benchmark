package am.noah.benchmark.minestom;

import am.noah.benchmark.minestom.bridge.MinestomBridge;
import am.noah.benchmark.minestom.listener.JoinListener;
import net.minestom.server.MinecraftServer;
import net.minestom.server.event.GlobalEventHandler;
import net.minestom.server.extensions.Extension;

public class BenchmarkPlugin extends Extension {

    MinestomBridge minestomBridge;

    /*
     * These are our Getters.
     * This allows us to access the information saved within this class in an easy and neat manner.
     * I could just use Lombok, but I am not a fan of Lombok.
     */

    /**
     * Return the MinestomBridge object stored within this class.
     */
    public MinestomBridge getMinestomBridge() {
        return minestomBridge;
    }

    /*
     * The following are important events which will be called by the Minestom Extension class.
     */

    /**
     * This method is called when the plugin has been enabled.
     * This allows us to start everything we need to start.
     */
    @Override
    public LoadStatus initialize() {

        GlobalEventHandler geh = MinecraftServer.getGlobalEventHandler();
        geh.addListener(new JoinListener(this));

        minestomBridge = new MinestomBridge(this);

        minestomBridge.pluginListSize(MinecraftServer.getExtensionManager().getExtensions().size());

        return LoadStatus.SUCCESS;
    }

    /**
     * This method is called when the plugin is being stopped.
     * This allows us to safely stop ongoing processes instead of them being stopped abruptly.
     */
    @Override
    public void terminate() {
        minestomBridge.stopCore();
        minestomBridge = null;
    }
}
