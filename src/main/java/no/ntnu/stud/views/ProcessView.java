package no.ntnu.stud.views;

import me.tongfei.progressbar.ProgressBar;
import me.tongfei.progressbar.ProgressBarBuilder;
import no.ntnu.stud.entity.Process;
import no.ntnu.stud.enums.ProcessEventEnum;
import no.ntnu.stud.listener.ProcessEventListener;

public class ProcessView extends ProcessEventListener {
  private int burstTime;
  private ProgressBar progressBar;

  public ProcessView(int processID, int burstTime) {
    this.burstTime = burstTime;
    ProgressBarBuilder progressBarBuilder =
        new ProgressBarBuilder().setTaskName("Process" + processID).setInitialMax(burstTime)
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
