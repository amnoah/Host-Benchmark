package am.noah.benchmark.core.manager.stage.type;

import am.noah.benchmark.core.Benchmark;
import am.noah.benchmark.core.manager.stage.StageManager;
import am.noah.benchmark.core.manager.test.TestManager;

public class MultiStage extends StageManager {
    /**
     * Initialize the MultiStage object, also starting the benchmark.
     */
    public MultiStage(Benchmark benchmark) {
        setBenchmark(benchmark);

        benchmark.getBridge().log("Starting the Multi Thread Benchmark. This will take 2.5 minutes");

        // Start a new Timer to end the stage.
        benchmark.getTimerManager().newTimer(benchmark, 150);

        setTestManager(new TestManager(4));
    }

    /**
     * When the current stage ends we need to output the Multi Thread score and switch to the PostStage.
     */
    @Override
    public void endStage() {
        getBenchmark().getBridge().log("Multi Thread Score: " + getTestManager().finish());
        getBenchmark().getBridge().log("");

        getBenchmark().setStageManager(new PostStage(getBenchmark()));
    }

    /**
     * If we are abruptly stopped, for whatever reason, we stop the current test in order to save performance.
     */
    @Override
    public void endStageAbrupt() {
        getTestManager().finish();
    }
}
