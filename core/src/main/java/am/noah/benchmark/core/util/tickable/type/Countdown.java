package am.noah.benchmark.core.util.tickable.type;

import am.noah.benchmark.core.Benchmark;
import am.noah.benchmark.core.util.tickable.Tickable;

public class Countdown extends Tickable {

    Benchmark benchmark;

    final int targetTicks;
    int ticks = 0;

    /**
     * Initialize the Countdown object.
     * We must provide how many seconds the countdown should last in the form of an Integer.
     */
    public Countdown(Benchmark benchmark, int seconds) {
        this.benchmark = benchmark;
        targetTicks = seconds * 20;
    }

    /**
     * The main goal of this class is to act as a countdown between events.
     * Thus, we count ticks until we reach a target, at which point the object will basically kill itself.
     */
    @Override
    public void tick() {
        if (ticks++ == targetTicks) {
            benchmark.getTickManager().removeTickable(this);
            benchmark.getStageManager().endStage();
        }
    }
}
