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
      Process process = processes.getFirst();
      if (time < process.getArrivalTime()) {
        time = process.getArrivalTime();
      }
      try {
        Thread.sleep(process.getBurstTime());
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        System.out.println("Process " + process.getId() + " was interrupted.");
        return;
      }
      time += process.getBurstTime();
      System.out.println("Process " + process.getId() + " finished at " + time);
      processes.removeFirst();
    }
  }
}
