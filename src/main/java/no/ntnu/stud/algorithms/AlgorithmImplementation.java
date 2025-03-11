package no.ntnu.stud.algorithms;

import java.util.List;

import no.ntnu.stud.entity.Process;
import no.ntnu.stud.entity.SimulationResult;

public abstract class AlgorithmImplementation {
  public abstract void setProcesses(List<Process> processes);
  public abstract void sortProcesses();
  public abstract SimulationResult run();
}
