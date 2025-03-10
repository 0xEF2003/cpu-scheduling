package no.ntnu.stud.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
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
  private int burstTime;
  private int priority;

  @Override
  public String toString() {
    return "Process{" +
        "id=" + id +
        ", arrivalTime=" + arrivalTime +
        ", burstTime=" + burstTime +
        ", priority=" + priority +
        '}';
  }

  public int run() {
    int time = 0;
    while (time != burstTime) {
      try {
        Thread.sleep(1);
        time++;
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        System.out.println("Process " + id + " was interrupted.");
        return time;
      }
    }
    return time;
  }
}
