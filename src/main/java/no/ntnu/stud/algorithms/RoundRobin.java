package no.ntnu.stud.algorithms;

import java.util.Comparator;
import java.util.List;
import no.ntnu.stud.entity.Process;
import no.ntnu.stud.entity.SimulationResult;

public class RoundRobin extends AlgorithmImplementation {
  List<Process> processes;
  int quantum;

  public RoundRobin() {}

  public void setQuantum(int quantum) {
    this.quantum = quantum;
  }

  public void setProcesses(List<Process> processes) {
    this.processes = processes;
  }

  public void sortProcesses() {
    processes.sort(Comparator.comparingInt(Process::getArrivalTime));
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
      for (int i = 0; i < processes.size(); i++) {
        Process currentProcess = processes.get(i);
        int time = currentProcess.burst(this.quantum);
      }
      for (Process process : processes) {
          if (process.getProgressTime() >= process.getBurstTime()) {
              processes.remove(process);

          }
      }
    }

    int averageWaitingTime = sumWaitingTime / numberOfProcesses;
    int averageTurnAroundTime = averageWaitingTime + sumBurstTime / numberOfProcesses;
    SimulationResult result = new SimulationResult(averageWaitingTime, averageTurnAroundTime);

    return result;
  }
}
