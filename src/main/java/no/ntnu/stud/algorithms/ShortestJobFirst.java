package no.ntnu.stud.algorithms;

import java.util.Comparator;
import java.util.List;
import no.ntnu.stud.entity.Process;
import no.ntnu.stud.entity.SimulationResult;

public class ShortestJobFirst extends AlgorithmImplementation {

  public ShortestJobFirst() {
  }

  @Override
  public void sortProcesses() {
    super.getProcesses().sort(Comparator.comparingInt(Process::getBurstTime));
  }

}
