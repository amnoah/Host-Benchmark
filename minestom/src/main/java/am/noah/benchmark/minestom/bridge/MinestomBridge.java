package am.noah.benchmark.minestom.bridge;

import am.noah.benchmark.core.Benchmark;
import am.noah.benchmark.core.util.Bridge;
import am.noah.benchmark.minestom.BenchmarkPlugin;
import net.minestom.server.MinecraftServer;

public class MinestomBridge extends Bridge {

    BenchmarkPlugin plugin;

    /**
     * Initialize the MinestomBridge object.
     */
    public MinestomBridge(BenchmarkPlugin plugin) {
        this.plugin = plugin;
        setBenchmark(new Benchmark(this, MinecraftServer.getBrandName()));
    }

    /**
     * Log a line to Console when the Core calls for it.
     */
    @Override
    public void log(Object object) {
        System.out.println("[Benchmark] " + object);
    }

    /**
     * Shut down the server when the Core calls for it.
     */
    @Override
    public void stopServer() {
        MinecraftServer.stopCleanly();
        System.exit(0);
    }
}
