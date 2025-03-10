package no.ntnu.stud;

import no.ntnu.stud.algorithms.AlgorithmImplementationFactory;
import no.ntnu.stud.ui.CommandLineUserInterface;
import no.ntnu.stud.views.AlgorithmView;
import no.ntnu.stud.views.ProcessView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import no.ntnu.stud.algorithms.AlgorithmImplementation;
import no.ntnu.stud.factory.ProcessEventPublisherFactory;
import no.ntnu.stud.entity.Process;
import no.ntnu.stud.enums.AlgorithmEnum;
import no.ntnu.stud.enums.ProcessEventEnum;
import no.ntnu.stud.factory.ProcessFactory;
import no.ntnu.stud.publisher.ProcessEventPublisher;

/**
 * Hello world!
 */
public class App {
  private boolean running;
  private CommandLineUserInterface cli;

  public App() {
    this.cli = new CommandLineUserInterface();
  }

  public void start() {
    cli.greet();
    this.mainLoop();
    cli.goodbye();
  }

  private void mainLoop() {
    if (running) {
      return;
    }
    running = true;

    while (running) {

      // Get list of all supported algorithms
      List<AlgorithmView> algorithmViews = Stream.of(AlgorithmEnum.values())
          .map(AlgorithmView::new)
          .collect(Collectors.toList());

      // User selects one of the available algorithms
      AlgorithmView userSelection =
          cli.promptIndexedOptions("Please select algorithm", algorithmViews);
      AlgorithmImplementation algorithm =
          AlgorithmImplementationFactory.create(userSelection.getAlgorithm());

      // User enters how many processes to spawn and max burst time
      int numberOfProcesses = cli.promptInt("Please enter amount of processes to schedule");
      int maxBurstTime = cli.promptInt("Please enter max burst time");

      // Prepare simulation
      List<Process> processes = ProcessFactory.createN(numberOfProcesses, maxBurstTime);
      List<ProcessEventPublisher> eventPublishers =
          ProcessEventPublisherFactory.createN(numberOfProcesses);
      List<ProcessView> processViews = new ArrayList<>();

      int i = 0;
      while (i < numberOfProcesses) {
        Process process = processes.get(i);
        ProcessEventPublisher publisher = eventPublishers.get(i);
        ProcessView view = new ProcessView(i, process.getBurstTime());
        process.setEventPublisher(publisher);
        publisher.subscribe(ProcessEventEnum.PROGRESS_TIME_UPDATED, view);
        processViews.add(view);
        i++;
      }

      // Run simulation
      algorithm.setProcesses(processes);
      algorithm.run();
    }
  }

}
