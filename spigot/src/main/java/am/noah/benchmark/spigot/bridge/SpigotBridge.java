package am.noah.benchmark.spigot.bridge;

import am.noah.benchmark.core.Benchmark;
import am.noah.benchmark.core.util.Bridge;
import am.noah.benchmark.spigot.BenchmarkPlugin;
import org.bukkit.Bukkit;

public class SpigotBridge extends Bridge {

    BenchmarkPlugin plugin;

    /**
     * Initialize the SpigotBridge object.
     */
    public SpigotBridge(BenchmarkPlugin plugin) {
        this.plugin = plugin;
        setBenchmark(new Benchmark(this, Bukkit.getVersion()));
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
        Bukkit.shutdown();
    }
}
