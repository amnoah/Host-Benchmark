package am.noah.benchmark.independent;

import am.noah.benchmark.independent.bridge.IndependentBridge;

public class BenchmarkMain {

    /**
     * This method is called when the program is started.
     * This allows us to start everything we need to start.
     */
    public static void main(String[] args) {
        new IndependentBridge();

        // Prevent the JVM from closing the program due to no processes being run on the main thread.
        while (true) {
            // Empty
        }
    }

}
