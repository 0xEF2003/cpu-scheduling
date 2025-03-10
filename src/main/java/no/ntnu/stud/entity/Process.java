package no.ntnu.stud.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * Process entity
 *
 * @param id          process id
 * @param arrivalTime process arrival time (In ms)
 * @param burstTime   process burst time (In ms)
 * @param priority    process priority (Higher number means higher priority)
 *
 * @return Process object
 */
public class Process {

  private int id;
  private int arrivalTime;
  private int progressTime;
  private int burstTime;
  private int priority;

  public Process(int id, int arrivalTime, int burstTime, int priority) {
    this.id = id;
    this.arrivalTime = arrivalTime;
    this.progressTime = 0;
    this.burstTime = burstTime;
    this.priority = priority;
  }

  public int run() {
    while (progressTime != burstTime) {
      try {
        Thread.sleep(1);
        progressTime++;
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        System.out.println(
            "Process " + id + " was interrupted. Progress: " + progressTime + "/" + burstTime);
      }
    }
    return progressTime;
  }
}
