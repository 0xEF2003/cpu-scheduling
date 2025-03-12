package no.ntnu.stud.entity;

import no.ntnu.stud.enums.ProcessEventEnum;
import no.ntnu.stud.publisher.ProcessEventPublisher;

/**
 * Process entity
 *
 * @param id          process id
 * @param arrivalTime process arrival time (In ms)
 * @param burstTime   process burst time (In ms)
 * @param priority    process priority (Higher number means higher priority)
 * @return Process object
 */
public class Process {

  private int id;
  private int arrivalTime;
  private int waitingTime;
  private int progressTime;
  private int burstTime;
  private int priority;
  private ProcessEventPublisher publisher;

  public Process(int id, int arrivalTime, int burstTime, int priority) {
    this.id = id;
    this.arrivalTime = arrivalTime;
    this.waitingTime = 0;
    this.progressTime = 0;
    this.burstTime = burstTime;
    this.priority = priority;
  }

  public int getId() {
    return this.id;
  }

  public int getArrivalTime() {
    return this.arrivalTime;
  }

  public int getWaitingTime() {
    return this.waitingTime;
  }

  public void setWaitingTime(int newWaitingTime) {
    if (newWaitingTime < 0) {
      throw new IllegalArgumentException("newWaitingTime must be positive");
    }

    if (newWaitingTime < this.waitingTime) {
      throw new IllegalArgumentException("newWaitingTime must be greater than current waitingTime");
    }

    this.waitingTime = newWaitingTime;
  }

  public int getProgressTime() {
    return this.progressTime;
  }

  public int getBurstTime() {
    return this.burstTime;
  }

  public int getPriority() {
    return this.priority;
  }

  public void setEventPublisher(ProcessEventPublisher publisher) {
    this.publisher = publisher;
  }

  public int burst() {
    return this.burst(this.burstTime);
  }

  public int burst(int quantum) {
    int time = 0;
    while (this.progressTime <= this.burstTime && time <= quantum) {
      try {
        Thread.sleep(1);
        this.progressTime += 1;
        time += 1;
        if (this.publisher != null) {
          this.publisher.notify(ProcessEventEnum.PROGRESS_TIME_UPDATED, this);
        }
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        System.out.println(
            "Process " + id + " was interrupted. Progress: " + progressTime + "/" + burstTime);
      }
    }
    return progressTime;
  }
}
