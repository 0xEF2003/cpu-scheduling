package no.ntnu.stud.views;

import java.text.MessageFormat;

import no.ntnu.stud.entity.SimulationResult;
import no.ntnu.stud.ui.Presentable;

public class SimulationResultView implements Presentable {
    private SimulationResult result;

    public SimulationResultView(SimulationResult result) {
        this.result = result;
    }

    public String present() {
        int averageWaitingTime = result.getAverageWaitingTime();
        int averageTurnAroundTime = result.getAverageTurnAroundTime();

        // Format output nicely
        String presentation = MessageFormat.format("""
            Average waiting time:     {0}ms
            Average turn around time: {1}ms
            """, averageWaitingTime, averageTurnAroundTime);

        return presentation;
    }
}
