package am.noah.benchmark.core.manager.stage.type;

import am.noah.benchmark.core.Benchmark;
import am.noah.benchmark.core.manager.stage.StageManager;

public class PauseStage extends StageManager {

    /**
     * Initialize the PauseStage object, also sending an explanation of what's going on and setting a 10 second Countdown.
     */
    public PauseStage(Benchmark benchmark) {
        setBenchmark(benchmark);

        benchmark.getBridge().log("Pausing for 10 seconds to let CPU usage normalize.");
        benchmark.getBridge().log("");

        // Add the Countdown to the TickManager.
        benchmark.getTimerManager().newTimer(benchmark, 10);
    }

    /**
     * When the current stage ends we need to set the StageManager to a MultiStage.
     */
    @Override
    public void endStage() {
        getBenchmark().setStageManager(new MultiStage(getBenchmark()));
    }
}
