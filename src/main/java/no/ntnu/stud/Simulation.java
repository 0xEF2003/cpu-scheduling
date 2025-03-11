package no.ntnu.stud;

import java.util.List;

import no.ntnu.stud.algorithms.AlgorithmImplementation;
import no.ntnu.stud.entity.Process;
import no.ntnu.stud.entity.SimulationResult;

public class Simulation {

  private AlgorithmImplementation algorithm;
  private List<Process> processes;

  public void setProcesses(List<Process> processes) {
    this.processes = processes;
  }

  public List<Process> getProcesses() {
    return processes;
  }

  public Simulation(AlgorithmImplementation algorithm, List<Process> processes) {
    this.algorithm = algorithm;
    this.processes = processes;
  }
    
  public SimulationResult run() {
    int sumWaitingTime = 0;
    int numberOfProcesses = processes.size();
    int sumBurstTime = 0;

    // Keep track of total burst time
    for (Process process : processes) {
      sumBurstTime += process.getBurstTime();
    }

    sumWaitingTime = this.algorithm.algorithm(processes);

    int averageWaitingTime = sumWaitingTime / numberOfProcesses;
    int averageTurnAroundTime = averageWaitingTime + sumBurstTime / numberOfProcesses;
    SimulationResult result = new SimulationResult(averageWaitingTime, averageTurnAroundTime);

    return result;
  }
}
