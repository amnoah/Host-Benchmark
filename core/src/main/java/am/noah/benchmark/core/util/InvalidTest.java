package am.noah.benchmark.core.util;

/**
 * This is basically just a centralized location where I keep error messages.
 * It's nice having them centralized, it makes them easy to update.
 */
public class InvalidTest {

    /**
     * Send a message in console if the server closes before the Benchmark concludes.
     */
    public String getEarlyShutdownResponse() {
        return "The server has shut down before all tests could be completed.";
    }

    /**
     * Send a message in console and shut down the server if the server has any other plugins installed.
     */
    public String getExcessivePluginsResponse() {
        return "Invalid Test - Please remove all other plugins before starting the Benchmark.";
    }

    /**
     * Send a message in console and shut down the server if any players join during the Benchmark.
     */
    public String getPlayerJoinResponse() {
        return "Invalid Test - Please do not let players join during the Benchmark.";
    }
}
