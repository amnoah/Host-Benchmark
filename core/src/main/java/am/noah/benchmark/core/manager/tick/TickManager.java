package am.noah.benchmark.core.manager.tick;

import am.noah.benchmark.core.util.tickable.Tickable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TickManager {

    Timer timer;

    /**
     * Upon initialization of the TickListener object we create a Timer with a delay of 50 milliseconds.
     * We simulate running something once per tick by doing this, making it completely platform independent.
     */
    public TickManager() {

        /*
         * Run whenever a "server tick" is called.
         * We go through all of the Tickables and run them.
         */

        timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Tickable tickable : actions) {
                    tickable.tick();
                }
            }
        });
    }

    private final List<Tickable> actions = new ArrayList<>();

    /**
     * Start the Timer.
     */
    public void start() {
        timer.start();
    }

    /**
     * Save a little performance during the server closing.
     */
    public void stop() {
        timer.stop();
    }

    /**
     * Add a Tickable to the List of Tickables that will be run every tick.
     */
    public void addTickable(Tickable tickable) {
        actions.add(tickable);
    }

    /**
     * Remove a Tickable from the List of Tickables that is run every tick.
     */
    public void removeTickable(Tickable tickable) {
        actions.remove(tickable);
    }
}
