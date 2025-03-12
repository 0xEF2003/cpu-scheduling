package no.ntnu.stud.views;

import me.tongfei.progressbar.ProgressBar;
import me.tongfei.progressbar.ProgressBarBuilder;
import no.ntnu.stud.entity.Process;
import no.ntnu.stud.enums.ProcessEventEnum;
import no.ntnu.stud.listener.ProcessEventListener;

public class ProcessView extends ProcessEventListener {
  private int burstTime;
  private ProgressBar progressBar;

  public ProcessView(Process process) {
    this.burstTime = process.getBurstTime();
    String barName =
        String.format("PID %2d Arrival time: %2d Priority: %2d", process.getId(),
            process.getArrivalTime(), process.getPriority());
    ProgressBarBuilder progressBarBuilder =
        new ProgressBarBuilder()
            .setTaskName(barName)
            .setInitialMax(burstTime)
            .setUnit("ms", 1)
            .setMaxRenderedLength(100)
            .setUpdateIntervalMillis(1);
    this.progressBar = progressBarBuilder.build();
  }

  public void update(ProcessEventEnum event, Process process) {
    switch (event) {
      case PROGRESS_TIME_UPDATED -> {
        int progress = process.getProgressTime();
        if (progress <= burstTime) {
          this.progressBar.stepTo(progress);
        }
        if (progress >= burstTime) {
          this.progressBar.stepTo(burstTime);
          this.progressBar.close();
        }
      }
      default -> {
      }
    }
  }
}
