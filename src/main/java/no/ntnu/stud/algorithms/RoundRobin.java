package no.ntnu.stud.algorithms;

import java.util.Comparator;
import java.util.List;
import no.ntnu.stud.entity.Process;

public class RoundRobin extends Algorithm {
  int quantum;

  public RoundRobin() {
  }

  public void setQuantum(int quantum) {
    this.quantum = quantum;
  }

  @Override
  public List<Process> sortProcesses(List<Process> processes) {
    processes.sort(Comparator.comparingInt(Process::getArrivalTime));
    return processes;
  }

  @Override
  public int algorithm(List<Process> processes) {
    int processesLeft = processes.size();
    int sumWaitingTime = 0;
    int timeToRemove = 0;

    for (Process process : processes) {
      timeToRemove -= process.getArrivalTime();
    }

    while (!processes.isEmpty()) {
      processes = sortProcesses(processes);

      int i = 0;
      while (i < processesLeft) {
        // accumulate counters
        Process process = processes.get(i);
        int time = process.burst(quantum);
        sumWaitingTime += quantum * (processesLeft - 1);

        // remove finished process
        if (process.getProgressTime() >= process.getBurstTime()) {
          processes.remove(process);
          processesLeft--;
          i--; // list is shrunk
        }

        i++;
      }
    }

    return sumWaitingTime + timeToRemove;
  }
}
