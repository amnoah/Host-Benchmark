package am.noah.benchmark.core;

import am.noah.benchmark.core.manager.stage.StageManager;
import am.noah.benchmark.core.manager.stage.type.PreStage;
import am.noah.benchmark.core.manager.tick.TickManager;
import am.noah.benchmark.core.util.Bridge;
import am.noah.benchmark.core.util.InvalidTest;

public class Benchmark {

    private final static String VERSION = "1.0";

    private final String serverVersion;

    private final Bridge bridge;
    private final InvalidTest invalidTest;

    private final TickManager tickManager;
    private StageManager stageManager;

    /**
     * Initialize the Benchmark object.
     */
    public Benchmark(Bridge bridge, String serverVersion) {
        this.serverVersion = serverVersion;

        this.bridge = bridge;
        invalidTest = new InvalidTest(this);

        tickManager = new TickManager();
        stageManager = new PreStage(this);

        tickManager.start();
    }

    /*
     * These are our Getters.
     * This allows us to access the information saved within this class in an easy and neat manner.
     * I could just use Lombok, but I am not a fan of Lombok.
     */

    /**
     * Return the Bridge object stored within this class.
     */
    public Bridge getBridge() {
        return bridge;
    }

    /**
     * Return the InvalidTest object stored within this class.
     */
    public InvalidTest getInvalidTest() {
        return invalidTest;
    }

    /**
     * Return the stored Server Version String.
     */
    public String getServerVersion() {
        return serverVersion;
    }

    /**
     * Return the TickManager object stored within this class.
     */
    public TickManager getTickManager() {
        return tickManager;
    }

    /**
     * Return the StageManager object stored within this class.
     */
    public StageManager getStageManager() {
        return stageManager;
    }

    /**
     * Return the version number tracked within this main class.
     */
    public String getVersion() {
        return VERSION;
    }

    /*
     * These are our Setters.
     * This allows us to set the information saved within this class in an easy and neat manner.
     * I could just use Lombok, but I am not a fan of Lombok.
     */

    /**
     * Set the StageManager object stored within this class.
     */
    public void setStageManager(StageManager stageManager) {
        this.stageManager = stageManager;
    }

    /*
     *
     */
}
