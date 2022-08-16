package am.noah.benchmark.core.manager.timer;

import am.noah.benchmark.core.Benchmark;

import javax.swing.*;

public class TimerManager {

    Timer timer;

    /**
     * Instead of using the messy old system where I attempted to simulate ticks I realized... I can use a Timer to
     * trigger a function at the end of a period instead of every 50 milliseconds.
     * Yeah... sometimes the air in my head goes flat and does funny stuff.
     */
    public void newTimer(Benchmark benchmark, int seconds) {
        timer = new Timer(seconds * 1000, new Action(benchmark));
        timer.start();
    }

    /**
     * Stop the Timer object from running when necessary.
     */
    public void stopTimer() {
        if (timer != null) timer.stop();
    }
}
