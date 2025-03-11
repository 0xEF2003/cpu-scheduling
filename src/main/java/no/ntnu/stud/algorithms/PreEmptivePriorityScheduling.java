package no.ntnu.stud.algorithms;

import java.util.List;

import no.ntnu.stud.entity.Process;

public class PreEmptivePriorityScheduling extends ProcessByProcessAlgorithm {

  @Override
  public List<Process> sortProcesses(List<Process> processes) {
    processes.sort((p1, p2) -> {
      if (p1.getPriority() == p2.getPriority()) {
        return p1.getArrivalTime() - p2.getArrivalTime();
      }
      return p2.getPriority() - p1.getPriority();
    });
    return processes;
  }

}
