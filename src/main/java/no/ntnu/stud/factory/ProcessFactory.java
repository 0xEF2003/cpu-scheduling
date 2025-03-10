package no.ntnu.stud.factory;

import java.util.List;
import java.util.Random;

import no.ntnu.stud.entity.Process;

import java.util.ArrayList;

public class ProcessFactory {
  public static List<Process> createN(int amountOfProcesses, int maxBurstTime) {
    List<Process> processes = new ArrayList<>();

    int i = 0;
    Random random = new Random();
    while (i < amountOfProcesses) {
      int burstTime = random.nextInt(maxBurstTime) + 1;
      int priority = random.nextInt(10) + 1;
      Process process = new Process(i, i, burstTime, priority);
      processes.add(process);
      i++;
    }

    return processes;
  }
}
