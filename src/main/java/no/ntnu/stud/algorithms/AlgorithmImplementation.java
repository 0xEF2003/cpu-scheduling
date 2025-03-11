package no.ntnu.stud.algorithms;

import java.util.List;

import no.ntnu.stud.entity.Process;
import no.ntnu.stud.entity.SimulationResult;

public abstract class AlgorithmImplementation {

  public abstract List<Process> sortProcesses(List<Process> processes);

  public abstract int algorithm(List<Process> processes);


}
