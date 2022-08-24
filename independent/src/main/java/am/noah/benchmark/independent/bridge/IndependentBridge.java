package am.noah.benchmark.independent.bridge;

import am.noah.benchmark.core.Benchmark;
import am.noah.benchmark.core.util.Bridge;

public class IndependentBridge extends Bridge {

    /**
     * Initialize the IndependentBridge object.
     */
    public IndependentBridge() {
        setBenchmark(new Benchmark(this, "Independent"));
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
        System.exit(0);
    }
}
