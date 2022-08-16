package am.noah.benchmark.core.util;

import am.noah.benchmark.core.Benchmark;

public class InvalidTest {

    Benchmark benchmark;

    /**
     * Initialize the InvalidTest object.
     */
    public InvalidTest(Benchmark benchmark) {
        this.benchmark = benchmark;
    }

    /**
     * Send a message in console if the server closes before the Benchmark concludes.
     */
    public void earlyShutdown() {
        benchmark.getBridge().log("The server has shut down before all tests could be completed.");
    }

    /**
     * Send a message in console and shut down the server if any players join during the Benchmark.
     */
    public void joinEvent() {
        benchmark.getBridge().log("Invalid Test - Please do not let players join during the Benchmark.");
        benchmark.getBridge().shutdown();
    }

    /**
     * Send a message in console and shut down the server if the server has any other plugins installed.
     */
    public void pluginsInstalled() {
        benchmark.getBridge().log("Invalid Test - Please remove all other plugins before starting the Benchmark.");
        benchmark.getBridge().shutdown();
    }
}
