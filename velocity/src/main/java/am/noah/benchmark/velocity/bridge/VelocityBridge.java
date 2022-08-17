package am.noah.benchmark.velocity.bridge;

import am.noah.benchmark.core.Benchmark;
import am.noah.benchmark.core.util.Bridge;
import am.noah.benchmark.velocity.BenchmarkPlugin;

public class VelocityBridge extends Bridge {

    BenchmarkPlugin plugin;

    /**
     * Initialize the VelocityBridge object.
     */
    public VelocityBridge(BenchmarkPlugin plugin) {
        this.plugin = plugin;
        setBenchmark(new Benchmark(this, "Velocity " + plugin.getServer().getVersion().getVersion()));
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
        plugin.getServer().shutdown();
    }
}
