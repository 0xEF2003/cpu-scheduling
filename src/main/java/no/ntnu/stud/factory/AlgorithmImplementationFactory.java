package no.ntnu.stud.factory;

import no.ntnu.stud.algorithms.AlgorithmImplementation;
import no.ntnu.stud.algorithms.FirstComeFirstServe;
import no.ntnu.stud.algorithms.PreEmptivePriorityScheduling;
import no.ntnu.stud.algorithms.RoundRobin;
import no.ntnu.stud.algorithms.ShortestJobFirst;
import no.ntnu.stud.enums.AlgorithmEnum;

public class AlgorithmImplementationFactory {
  public static AlgorithmImplementation create(AlgorithmEnum algorithm) {
    switch (algorithm) {
      case FIRST_COME_FIRST_SERVE -> {
        return new FirstComeFirstServe();
      }
      case PRIORITY -> {
        return new PreEmptivePriorityScheduling();
      }
      case SJF -> {
        return new ShortestJobFirst();
      }
      case ROUND_ROBIN -> {
        return new RoundRobin();
      }
      default -> {
        return null;
      }
    }
  }
}
