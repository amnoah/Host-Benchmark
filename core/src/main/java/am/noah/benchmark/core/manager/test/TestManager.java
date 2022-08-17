package am.noah.benchmark.core.manager.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.LongAdder;

public class TestManager {

    LongAdder score = new LongAdder();

    List<Test> activeTests = new ArrayList<>();
    List<Thread> activeThreads = new ArrayList<>();

    /**
     * Initialize the TestManager, also creating however many Test Threads are needed.
     */
    public TestManager(int threads) {

        // Create however many test threads are specified.
        for (int i = 0; i < threads; i++) {
            Test test = new Test(score);

            activeTests.add(test);
            activeThreads.add(new Thread(test));
        }

        // Start all of the test threads.
        for (Thread thread : activeThreads) {
            thread.start();
        }
    }

    /**
     * Tell the TestManager to stop the tests, returning the total score of the test.
     */
    public long finish() {
        // Turn off all of the tests to save performance.
        for (Test test : activeTests) {
            String unused = test.getIntensiveString();
            test.stop();
        }

        // Return the total score of the test (however many runs the CPU was capable of doing).
        return score.sum();
    }
}