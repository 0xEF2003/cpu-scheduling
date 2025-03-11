package no.ntnu.stud.algorithms;

import java.util.List;

import no.ntnu.stud.entity.Process;
import no.ntnu.stud.entity.SimulationResult;

public class PreEmptivePriorityScheduling extends AlgorithmImplementation {
  private List<Process> processes;

  public PreEmptivePriorityScheduling() {}

  public void setProcesses(List<Process> processes) {
    this.processes = processes;
  }

  public void sortProcesses() {
    processes.sort((p1, p2) -> {
      if (p1.getPriority() == p2.getPriority()) {
        return p1.getArrivalTime() - p2.getArrivalTime();
      }
      return p2.getPriority() - p1.getPriority();
    });
  }

  public SimulationResult run() {
    int sumWaitingTime = 0;
    int numberOfProcesses = processes.size();
    int sumBurstTime = 0;

    // Keep track of total burst time
    for (Process process : processes) {
        sumBurstTime += process.getBurstTime();
    }

    while (!processes.isEmpty()) {
      sortProcesses();

      Process currentProcess = processes.getFirst();
      int time = currentProcess.burst();
      processes.removeFirst();

      sumWaitingTime += time * processes.size();
    }


    int averageWaitingTime = sumWaitingTime / numberOfProcesses;
    int averageTurnAroundTime = averageWaitingTime + sumBurstTime / numberOfProcesses;
    SimulationResult result = new SimulationResult(averageWaitingTime, averageTurnAroundTime);

    return result;
  }
}
