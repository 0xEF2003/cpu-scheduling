package no.ntnu.stud.algorithms;

import no.ntnu.stud.algorithms.AlgorithmImplementation;
import no.ntnu.stud.enums.AlgorithmEnum;

public class AlgorithmImplementationFactory {
    public static AlgorithmImplementation create(AlgorithmEnum algorithm) {
        switch (algorithm) {
            case FIRST_COME_FIRST_SERVE -> { return new FirstComeFirstServe(); }
            case PRIORITY -> { return new PreEmptivePriorityScheduling(); }
            default -> { return null; }
        }
    }
}
