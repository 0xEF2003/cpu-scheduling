package no.ntnu.stud.factory;

import no.ntnu.stud.algorithms.Algorithm;
import no.ntnu.stud.algorithms.FirstComeFirstServe;
import no.ntnu.stud.algorithms.NonPreEmptivePriorityScheduling;
import no.ntnu.stud.algorithms.RoundRobin;
import no.ntnu.stud.algorithms.ShortestJobFirst;
import no.ntnu.stud.enums.AlgorithmEnum;

public class AlgorithmFactory {
  public static Algorithm create(AlgorithmEnum algorithm) {
    switch (algorithm) {
      case FIRST_COME_FIRST_SERVE -> {
        return new FirstComeFirstServe();
      }
      case PRIORITY -> {
        return new NonPreEmptivePriorityScheduling();
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
