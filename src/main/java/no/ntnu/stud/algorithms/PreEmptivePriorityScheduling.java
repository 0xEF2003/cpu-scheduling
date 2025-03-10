package no.ntnu.stud.algorithms;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import no.ntnu.stud.entity.Process;

@NoArgsConstructor
@AllArgsConstructor
public class PreEmptivePriorityScheduling
    extends AlgorithmImplementation {
  private List<Process> processes;

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

  public void run() {
    int time = 0;
    while (!processes.isEmpty()) {
      sortProcesses();
      Process currentProcess = processes.getFirst();
      time += currentProcess.burst();
      System.out.println(
          "Process " + currentProcess.getId() + " finished at " + time + " with priority " +
              currentProcess.getPriority());
      processes.removeFirst();
    }
  }
}
