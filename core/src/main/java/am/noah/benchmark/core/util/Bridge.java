package am.noah.benchmark.core.util;

import am.noah.benchmark.core.Benchmark;
import am.noah.benchmark.core.manager.stage.type.PostStage;

/**
 * This class acts as a Bridge between the Core and the platform that the plugin is working on.
 * Data can be sent through this Bridge in order to be easily platform independent.
 */
public class Bridge {

    Benchmark benchmark;

    /**
     * Set a Benchmark object that the Bridge is able to connect to.
     */
    public void setBenchmark(Benchmark benchmark) {
        this.benchmark = benchmark;
    }

    /*
     * Any extending classes will perform functions as needed when the following void is run.
     */

    /**
     * Allow extending classes to Override this void, letting them log whatever is sent.
     */
    public void log(Object object) {
        // Unused
    }

    /**
     * Allow extending classes to Override this void, letting them handle shutting down on whichever platform.
     */
    public void stopServer() {
        // Unused
    }

    /*
     * Any extending classes can run the following voids in order to perform certain actions.
     */

    /**
     * Run when a native Player Join Event has been called to pass it along to the Core.
     */
    public void joinEvent() {
        log(benchmark.getInvalidTest().getPlayerJoinResponse());
        stopServer();
    }

    /**
     * Run in order to inform the Core of the amount of plugins present on the server.
     */
    public void pluginListSize(int size) {
        if (size > 1) {
            log(benchmark.getInvalidTest().getExcessivePluginsResponse());
            stopServer();
        }
    }

    /**
     * Run in order to inform the Core of a server closing event.
     */
    public void stopCore() {
        benchmark.getTimerManager().stopTimer();
        if (!(benchmark.getStageManager() instanceof PostStage)) log(benchmark.getInvalidTest().getEarlyShutdownResponse());
    }
}
