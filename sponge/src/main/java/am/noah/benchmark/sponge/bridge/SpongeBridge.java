package am.noah.benchmark.sponge.bridge;

import am.noah.benchmark.core.Benchmark;
import am.noah.benchmark.core.util.Bridge;
import am.noah.benchmark.sponge.BenchmarkPlugin;
import org.spongepowered.api.Sponge;

public class SpongeBridge extends Bridge {

    private final BenchmarkPlugin plugin;

    /**
     * Initialize the SpongeBridge object.
     */
    public SpongeBridge(BenchmarkPlugin plugin) {
        this.plugin = plugin;
        setBenchmark(new Benchmark(this, Sponge.platform().minecraftVersion().name()));
    }

    /**
     * Log a line to Console when the Core calls for it.
     */
    @Override
    public void log(Object object) {
        this.plugin.getLogger().info(object.toString());
    }

    /**
     * Shut down the server when the Core calls for it.
     */
    @Override
    public void stopServer() {
        Sponge.server().shutdown();
    }
}
