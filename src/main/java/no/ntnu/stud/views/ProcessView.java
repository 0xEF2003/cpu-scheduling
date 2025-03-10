package no.ntnu.stud.views;

import me.tongfei.progressbar.ProgressBar;
import me.tongfei.progressbar.ProgressBarBuilder;
import me.tongfei.progressbar.ProgressBarStyle;
import no.ntnu.stud.entity.Process;
import no.ntnu.stud.enums.ProcessEventEnum;
import no.ntnu.stud.listener.ProcessEventListener;

public class ProcessView extends ProcessEventListener {
  private int burstTime;
  private ProgressBar progressBar;

  public ProcessView(int processID, int burstTime) {
    this.burstTime = burstTime;
    ProgressBarBuilder progressBarBuilder =
        new ProgressBarBuilder().setInitialMax(burstTime)
            .setTaskName("Process " + processID);
    this.progressBar = progressBarBuilder.build();
  }

  public void update(ProcessEventEnum event, Process process) {
    switch (event) {
      case PROGRESS_TIME_UPDATED -> {
        int progress = process.getProgressTime();
        this.progressBar.stepTo(progress);
      }
      default -> {
      }
    }
  }
}
