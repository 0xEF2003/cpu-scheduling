package no.ntnu.stud.algorithms;

import java.util.List;

import no.ntnu.stud.entity.Process;
import no.ntnu.stud.entity.SimulationResult;

public class PreEmptivePriorityScheduling extends AlgorithmImplementation {

  public PreEmptivePriorityScheduling() {
  }

  @Override
  public void sortProcesses() {
    super.getProcesses().sort((p1, p2) -> {
      if (p1.getPriority() == p2.getPriority()) {
        return p1.getArrivalTime() - p2.getArrivalTime();
      }
      return p2.getPriority() - p1.getPriority();
    });
  }
}
