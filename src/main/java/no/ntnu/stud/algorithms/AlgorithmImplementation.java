package no.ntnu.stud.algorithms;

import java.util.List;

import no.ntnu.stud.entity.Process;

public abstract class AlgorithmImplementation {
  public abstract void setProcesses(List<Process> processes);
  public abstract void sortProcesses();
  public abstract void run();
}
