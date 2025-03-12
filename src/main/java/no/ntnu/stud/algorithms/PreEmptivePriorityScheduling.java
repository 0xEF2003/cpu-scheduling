package no.ntnu.stud.algorithms;

import java.util.List;
import no.ntnu.stud.entity.Process;

public class PreEmptivePriorityScheduling extends Algorithm {

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

  @Override
  public int algorithm(List<Process> processes) {
    int time = 0;
    int sumWaitingTime = 0;
    while (!processes.isEmpty()) {
      processes = sortProcesses(processes);
      Process currentProcess = null;
      boolean processFound = false;

      // Find the first process that has arrived
      for (Process process : processes) {
        if (process.getArrivalTime() <= time) {
          currentProcess = process;
          processFound = true;
          break;
        }
      }

      if (!processFound) {
        // If no process has arrived, increment time
        time++;
      } else {
        currentProcess.burst(1);
        time++;

        for (Process process : processes) {
          if (process != currentProcess && process.getArrivalTime() <= time) {
            process.setWaitingTime(process.getWaitingTime() + 1);
          }
        }

        if (currentProcess.getProgressTime() >= currentProcess.getBurstTime()) {
          sumWaitingTime += currentProcess.getWaitingTime();
          processes.remove(currentProcess);
        }
      }
    }

    return sumWaitingTime;
  }
}
