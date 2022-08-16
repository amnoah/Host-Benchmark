package am.noah.benchmark.core.manager.stage.type;

import am.noah.benchmark.core.Benchmark;
import am.noah.benchmark.core.manager.stage.StageManager;
import am.noah.benchmark.core.util.tickable.Tickable;

public class PostStage extends StageManager {

    /**
     * Initialize the PostStage object.
     */
    public PostStage(Benchmark benchmark) {
        benchmark.getBridge().log("The Benchmark has concluded.");
        benchmark.getBridge().log("");

        // Shut down the server as we're finished.
        benchmark.getBridge().shutdown();

        // Prevents a console error.
        benchmark.getTickManager().addTickable(new Tickable());
    }
}
