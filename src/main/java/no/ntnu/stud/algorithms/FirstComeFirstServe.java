package no.ntnu.stud.algorithms;

import java.util.Comparator;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import no.ntnu.stud.entity.Process;

@NoArgsConstructor
@AllArgsConstructor
public class FirstComeFirstServe extends AlgorithmImplementation {
  List<Process> processes;

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
