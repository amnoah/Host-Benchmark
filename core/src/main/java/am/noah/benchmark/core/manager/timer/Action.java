package am.noah.benchmark.core.manager.timer;

import am.noah.benchmark.core.Benchmark;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Action implements ActionListener {

    Benchmark benchmark;

    /**
     * Initialize the Action object.
     */
    public Action(Benchmark benchmark) {
        this.benchmark = benchmark;
    }

    /**
     * This void will be called at the end of a Action, ending the current Stage.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        benchmark.getTimerManager().stopTimer();
        benchmark.getStageManager().endStage();
    }
}
