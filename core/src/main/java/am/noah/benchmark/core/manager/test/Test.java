package am.noah.benchmark.core.manager.test;

import java.util.concurrent.atomic.LongAdder;

public class Test implements Runnable {

    LongAdder runCounter;

    boolean testActive = true;

    /**
     * Initialize the Test object.
     */
    public Test(LongAdder runCounter) {
        this.runCounter = runCounter;
    }

    /**
     * This is meant to be extremely intensive... and it is!
     * This stress tests the CPU seriously... per counted run it must run the code 16,777,216 times!
     */
    @Override
    public void run() {
        while (testActive) {
            for (int a = 0; a < 16777216; a++) {
                final double intensive = Math.hypot(Math.PI, Math.PI);
            }

            runCounter.increment();
        }
    }

    /**
     * We stop the intensive test before the TestManager is overwritten.
     * This is because a few tasks still have to be performed before it's overwritten, and it's best if we save performance
     * for those tasks.
     */
    public void stop() {
        testActive = false;
    }
}
