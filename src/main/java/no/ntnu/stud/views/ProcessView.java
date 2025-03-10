package no.ntnu.stud.views;

import me.tongfei.progressbar.ProgressBar;
import no.ntnu.stud.entity.Process;
import no.ntnu.stud.enums.ProcessEventEnum;
import no.ntnu.stud.listener.ProcessEventListener;

public class ProcessView extends ProcessEventListener {
  private int burstTime;
  private ProgressBar progressBar;

  public ProcessView(int processID, int burstTime) {
    this.burstTime = burstTime;
    this.progressBar = new ProgressBar("Process" + processID, burstTime);
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
