package no.ntnu.stud.entity;


//TODO: Do final calulation of average waiting time and average turn around time, See if it is correct or not
// https://process-scheduling-solver.boonsuen.com/
public class SimulationResult {
  private int averageWaitingTime;
  private int averageTurnAroundTime;

  public SimulationResult(int averageWaitingTime, int averageTurnAroundTime) {
    this.averageWaitingTime = averageWaitingTime;
    this.averageTurnAroundTime = averageTurnAroundTime;
  }

  public int getAverageWaitingTime() {
    return averageWaitingTime;
  }

  public int getAverageTurnAroundTime() {
    return averageTurnAroundTime;
  }


}
