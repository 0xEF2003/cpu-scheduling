package no.ntnu.stud.algorithms;

import java.util.Comparator;
import java.util.List;
import no.ntnu.stud.entity.Process;

public class FirstComeFirstServe implements AlgorithmImplementation {
  List<Process> processes;

  public FirstComeFirstServe(List<Process> processes) {
    this.processes = processes;
  }

  public void sortProcesses() {
    processes.sort(Comparator.comparingInt(Process::getArrivalTime));
  }

  public void run() {
    int time = 0;
    while (!processes.isEmpty()) {
      sortProcesses();
      Process currentProcess = processes.getFirst();
      time += currentProcess.run();
      System.out.println("Process " + currentProcess.getId() + " finished at " + time);
      processes.removeFirst();
    }
  }
}
