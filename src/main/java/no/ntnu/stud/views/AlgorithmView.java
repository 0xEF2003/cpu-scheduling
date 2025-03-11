package no.ntnu.stud.views;

import no.ntnu.stud.interfaces.Presentable;
import no.ntnu.stud.enums.AlgorithmEnum;
import no.ntnu.stud.exceptions.StringPresentException;

public class AlgorithmView implements Presentable {
  private AlgorithmEnum algorithm;

  public AlgorithmView(AlgorithmEnum algorithm) {
    this.algorithm = algorithm;
  }

  public String present() throws StringPresentException {
    switch (this.algorithm) {
      case FIRST_COME_FIRST_SERVE -> {
        return "First Come First Serve";
      }
      case PRIORITY -> {
        return "Pre-emptive Priority Scheduling";
      }
      case SJF -> {
        return "Shortest Job First";
      }
      case ROUND_ROBIN -> {
        return "Round Robin";
      }
      default -> {
        throw new StringPresentException("Failed to present algorithm type: not known");
      }
    }
  }

  public AlgorithmEnum getAlgorithm() {
    return this.algorithm;
  }
}
