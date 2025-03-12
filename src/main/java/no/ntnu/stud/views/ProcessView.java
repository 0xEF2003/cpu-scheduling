package no.ntnu.stud.views;

import java.util.Optional;

import me.tongfei.progressbar.ProgressBar;
import me.tongfei.progressbar.ProgressBarBuilder;
import no.ntnu.stud.entity.Process;
import no.ntnu.stud.enums.ProcessEventEnum;
import no.ntnu.stud.listener.ProcessEventListener;

public class ProcessView extends ProcessEventListener {
    private Process process;
  private ProgressBar progressBar;

  public ProcessView(Process process) {
    this.process = process;

    String barName =
        String.format("PID:%3d  PL: %2d  AT:%3dms", 
            process.getId(),
            process.getPriority(), 
            process.getArrivalTime());

    int burstTime = process.getBurstTime();
    ProgressBarBuilder progressBarBuilder =
        new ProgressBarBuilder()
            .setTaskName(barName)
            .setInitialMax(burstTime)
            .setUnit("ms", 1)
            .setUpdateIntervalMillis(1);

    this.progressBar = progressBarBuilder.build();
  }

  public void update(ProcessEventEnum event, Process process) {
    switch (event) {
      case PROGRESS_TIME_UPDATED -> {
        int progress = process.getProgressTime();
        int burstTime = process.getBurstTime();

        if (progress <= burstTime) {
          this.progressBar.stepTo(progress);
        }

        if (progress >= burstTime) {
          this.progressBar.stepTo(burstTime);
          this.progressBar.close();
        }

      }
      default -> { }
    }
  }
}
