package no.ntnu.stud.algorithms;

import java.util.Comparator;
import java.util.List;
import no.ntnu.stud.entity.Process;
import no.ntnu.stud.entity.SimulationResult;

public class ShortestJobFirst extends AlgorithmImplementation {
  List<Process> processes;

  public ShortestJobFirst() {
  }

  public void setProcesses(List<Process> processes) {
    this.processes = processes;
  }

  public void sortProcesses() {
    processes.sort(Comparator.comparingInt(Process::getBurstTime));
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

      // accumulate waiting time for all other processes
      sumWaitingTime += time * processes.size();
    }

    int averageWaitingTime = sumWaitingTime / numberOfProcesses;
    int averageTurnAroundTime = averageWaitingTime + sumBurstTime / numberOfProcesses;
    SimulationResult result = new SimulationResult(averageWaitingTime, averageTurnAroundTime);

    return result;
  }
}
