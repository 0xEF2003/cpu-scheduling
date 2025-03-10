package no.ntnu.stud.algorithms;

import java.util.Comparator;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import no.ntnu.stud.entity.Process;

@NoArgsConstructor
@AllArgsConstructor
public class RoundRobin extends AlgorithmImplementation {
  List<Process> processes;
  int quantum;

  public RoundRobin(int quantum) {
    this.quantum = quantum;
  }

  public void setProcesses(List<Process> processes) {
    this.processes = processes;
  }

  public void sortProcesses() {
    processes.sort(Comparator.comparingInt(Process::getArrivalTime));
  }

  public void run() {
    int time = 0;
    while (!processes.isEmpty()) {
      sortProcesses();
      for (int i = 0; i < processes.size(); i++) {
        Process currentProcess = processes.get(i);
        time += currentProcess.burst(this.quantum);
        System.out.println("Process " + currentProcess.getId() + " finished at " + time);
        processes.remove(i);
      }
    }
  }
}
