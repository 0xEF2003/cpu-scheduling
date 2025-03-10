package no.ntnu.stud.algorithms;

import no.ntnu.stud.enums.AlgorithmEnum;

public class AlgorithmImplementationFactory {
    public static AlgorithmImplementation create(AlgorithmEnum algorithm) {
        switch (algorithm) {
            case AlgorithmEnum.FIRST_COME_FIRST_SERVE -> { return new FirstComeFirstServe(); }
            case AlgorithmEnum.PRIORITY -> { return new PreEmptivePriorityScheduling(); }
            default -> { return null; }
        }
    }
}
