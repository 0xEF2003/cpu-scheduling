package no.ntnu.stud.algorithms;

import java.util.Comparator;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import no.ntnu.stud.entity.Process;

@NoArgsConstructor
@AllArgsConstructor
public class ShortestJobFirst extends AlgorithmImplementation {
  List<Process> processes;


  public void setProcesses(List<Process> processes) {
    this.processes = processes;
  }

  public void sortProcesses() {
    processes.sort(Comparator.comparingInt(Process::getBurstTime));
  }

  public void run() {
    int time = 0;
    while (!processes.isEmpty()) {
      sortProcesses();
      Process currentProcess = processes.getFirst();
      time += currentProcess.burst();
      System.out.println("Process " + currentProcess.getId() + " finished at " + time);
      processes.removeFirst();
    }
  }
}
