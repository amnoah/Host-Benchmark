package am.noah.benchmark.core.manager.stage.type;

import am.noah.benchmark.core.Benchmark;
import am.noah.benchmark.core.manager.stage.StageManager;
import am.noah.benchmark.core.manager.test.TestManager;

public class SingleStage extends StageManager {

    /**
     * Initialize the SingleStage object, also starting the benchmark.
     */
    public SingleStage(Benchmark benchmark) {
        setBenchmark(benchmark);

        benchmark.getBridge().log("Starting the Single Thread Benchmark. This will take 2.5 minutes");

        // Start a new Timer to end the stage.
        benchmark.getTimerManager().newTimer(benchmark, 150);

        setTestManager(new TestManager(1));
    }

    /**
     * When the current stage ends we need to output the Single Thread score and switch to the PauseStage.
     */
    @Override
    public void endStage() {
        getBenchmark().getBridge().log("Single Thread Score: " + getTestManager().finish());
        getBenchmark().getBridge().log("");

        getBenchmark().setStageManager(new PauseStage(getBenchmark()));
    }

    /**
     * If we are abruptly stopped, for whatever reason, we stop the current test in order to save performance.
     */
    @Override
    public void endStageAbrupt() {
        getTestManager().finish();
    }
}
