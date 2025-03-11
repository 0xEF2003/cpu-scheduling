package no.ntnu.stud.algorithms;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import no.ntnu.stud.entity.Process;
import no.ntnu.stud.entity.SimulationResult;

public class RoundRobin extends AlgorithmImplementation {
  int quantum;

  public RoundRobin() {
  }

  public void setQuantum(int quantum) {
    this.quantum = quantum;
  }

  @Override
  public SimulationResult run() {
    int sumWaitingTime = 0;
    int numberOfProcesses = super.getProcesses().size();
    int sumBurstTime = 0;
    int time = 0;

    // Keep track of total burst time
    for (Process process : super.getProcesses()) {
      sumBurstTime += process.getBurstTime();
    }

    while (!super.getProcesses().isEmpty()) {
      sortProcesses();
      Iterator<Process> iterator = super.getProcesses().iterator();
      while (iterator.hasNext()) {
        Process currentProcess = iterator.next();
        int burstTime = currentProcess.burst(quantum);
        time += burstTime;
        currentProcess.setWaitingTime(time);
        if (currentProcess.getProgressTime() >= currentProcess.getBurstTime()) {
          iterator.remove();
          sumWaitingTime += currentProcess.getWaitingTime();
        }
      }
    }

    int averageWaitingTime = sumWaitingTime / numberOfProcesses;
    int averageTurnAroundTime = averageWaitingTime + sumBurstTime / numberOfProcesses;
    SimulationResult result = new SimulationResult(averageWaitingTime, averageTurnAroundTime);

    return result;
  }
}
