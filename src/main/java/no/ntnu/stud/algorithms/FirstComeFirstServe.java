package no.ntnu.stud.algorithms;

import java.util.Comparator;
import java.util.List;

import no.ntnu.stud.entity.Process;

public class FirstComeFirstServe extends ProcessByProcessAlgorithm {

  @Override
  public List<Process> sortProcesses(List<Process> processes) {
    processes.sort(Comparator.comparingInt(Process::getArrivalTime));
    return processes;
  }


}
