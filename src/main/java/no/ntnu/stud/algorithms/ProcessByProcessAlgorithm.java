package no.ntnu.stud.algorithms;

import java.util.List;

import no.ntnu.stud.entity.Process;

public abstract class ProcessByProcessAlgorithm extends Algorithm {
    
  @Override
  public int algorithm(List<Process> processes) {
    int sumWaitingTime = 0;
    while (!processes.isEmpty()) {
      processes = sortProcesses(processes);

      Process currentProcess = processes.getFirst();
      int time = currentProcess.burst();
      processes.removeFirst();

      // accumulate waiting time for all other processes
      sumWaitingTime += time * processes.size();
    }
    return sumWaitingTime;
   }

}
