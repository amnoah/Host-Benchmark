package am.noah.benchmark.core.manager.stage;

import am.noah.benchmark.core.Benchmark;
import am.noah.benchmark.core.manager.test.TestManager;

public class StageManager {

    Benchmark benchmark;

    TestManager testManager;

    /*
     * These are our Getters.
     * This allows us to access the information saved within this class in an easy and neat manner.
     * I could just use Lombok, but I am not a fan of Lombok.
     */

    /**
     * Return the Benchmark object stored within this class.
     */
    public Benchmark getBenchmark() {
        return benchmark;
    }

    /**
     * Return the TestManager object stored within this class.
     */
    public TestManager getTestManager() {
        return testManager;
    }

    /*
     * These are our Setters.
     * This allows us to set the information saved within this class in an easy and neat manner.
     * I could just use Lombok, but I am not a fan of Lombok.
     */

    /**
     * Set the Benchmark object stored within this class.
     */
    public void setBenchmark(Benchmark benchmark) {
        this.benchmark = benchmark;
    }

    /**
     * Set the TestManager object stored within this class.
     */
    public void setTestManager(TestManager testManager) {
        this.testManager = testManager;
    }

    /*
     * Tell the StageManager that the current Stage has ended.
     */

    /**
     * Method to tell the StageManager and all extending classes that the stage has ended regularly.
     */
    public void endStage() {

    }

    /**
     * Method to tell the StageManager and all extending classes that the stage has ended abruptly,
     * meaning shut down procedures should be operated.
     */
    public void endStageAbrupt() {

    }
}
