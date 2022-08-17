package am.noah.benchmark.bungeecord.bridge;

import am.noah.benchmark.bungeecord.BenchmarkPlugin;
import am.noah.benchmark.core.Benchmark;
import am.noah.benchmark.core.util.Bridge;

public class BungeecordBridge extends Bridge {

    BenchmarkPlugin plugin;

    /**
     * Initialize the BungeecordBridge object.
     */
    public BungeecordBridge(BenchmarkPlugin plugin) {
        this.plugin = plugin;
        setBenchmark(new Benchmark(this, plugin.getProxy().getVersion()));
    }

    /**
     * Log a line to Console when the Core calls for it.
     */
    @Override
    public void log(Object object) {
        plugin.getLogger().info((String) object);
    }

    /**
     * Shut down the server when the Core calls for it.
     */
    @Override
    public void stopServer() {
        plugin.getProxy().stop();
    }
}
