package am.noah.benchmark.core.manager.test;

import java.util.concurrent.atomic.LongAdder;

public class Test implements Runnable {

    LongAdder runCounter;
    String intensive = "IntensiveBehavior";

    boolean testActive = true;

    /**
     * Initialize the Test object.
     */
    public Test(LongAdder runCounter) {
        this.runCounter = runCounter;
    }

    /**
     * This is meant to be extremely intensive... and it is!
     * This stress tests the CPU seriously... per counted run it must run the code 100,000 times!
     */
    @Override
    public void run() {
        String pastResult = intensive;

        while (testActive) {

            for (int i = 0; i < 100000; i++) {
                intensive = intensive.replaceAll("[0-9]", "");
                intensive = intensive + i;
                intensive = new StringBuilder(intensive).reverse().toString();
                String endHalf = pastResult.substring(0, (pastResult.length() / 2) - 1);
                intensive = intensive.substring((intensive.length() / 2) - 1);
                intensive = endHalf + intensive;
            }

            pastResult = intensive;

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

    /**
     * Make the JVM believe that the Intensive String is actually used.
     */
    public String getIntensiveString() {
        return intensive;
    }
}
