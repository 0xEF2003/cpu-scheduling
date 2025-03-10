package no.ntnu.stud.views;

import no.ntnu.stud.ui.Presentable;
import no.ntnu.stud.enums.Algorithm;
import no.ntnu.stud.exceptions.StringPresentException;

public class AlgorithmView implements Presentable {
    private Algorithm algorithm;

    public AlgorithmView(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    public String present() throws StringPresentException {
        switch (this.algorithm) {
            case Algorithm.FIRST_COME_FIRST_SERVE -> { return "First Come First Serve"; }
            case Algorithm.PRIORITY-> { return "Pre-emptive Priority Scheduling"; }
            default -> { throw new StringPresentException("Failed to present algorithm type: not known"); }
        }
    }

    public Algorithm getAlgorithm() {
        return this.algorithm;
    }
}
