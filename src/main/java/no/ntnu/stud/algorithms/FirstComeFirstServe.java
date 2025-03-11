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
    int numberOfProcesses = processes.size();
    while (!processes.isEmpty()) {
      sortProcesses();
      Process currentProcess = processes.getFirst();
      time += currentProcess.burst();
      System.out.println("Process " + currentProcess.getId() + " finished at " + time);
      processes.removeFirst();
      final int additionalWaitingTime = time;
      processes.stream().forEach(
        p -> p.setWaitingTime(p.getWaitingTime() + additionalWaitingTime)
      );
    }
    int averageWaitingTime = processes.stream()
      .mapToInt(p -> p.getWaitingTime())
      .sum() / numberOfProcesses;
    System.out.println("Average waiting time: " + averageWaitingTime);
  }
}
