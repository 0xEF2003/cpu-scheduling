package no.ntnu.stud;

import no.ntnu.stud.entity.SimulationResult;
import no.ntnu.stud.factory.AlgorithmFactory;
import no.ntnu.stud.ui.CommandLineUserInterface;
import no.ntnu.stud.views.AlgorithmView;
import no.ntnu.stud.views.AsciiArtView;
import no.ntnu.stud.views.ProcessView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import no.ntnu.stud.algorithms.Algorithm;
import no.ntnu.stud.algorithms.RoundRobin;
import no.ntnu.stud.factory.ProcessEventPublisherFactory;
import no.ntnu.stud.entity.Process;
import no.ntnu.stud.enums.AlgorithmEnum;
import no.ntnu.stud.enums.ProcessEventEnum;
import no.ntnu.stud.factory.ProcessFactory;
import no.ntnu.stud.publisher.ProcessEventPublisher;
import no.ntnu.stud.views.SimulationResultView;

/**
 * Hello world!
 */
public class App {
  private boolean running;
  private CommandLineUserInterface cli;
  private AsciiArtView artView;

  public App() {
    this.cli = new CommandLineUserInterface();
    this.artView = new AsciiArtView();
  }

  public void start() {
    artView.greet();
    this.mainLoop();
    artView.goodbye();
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
      AlgorithmEnum selectedAlgorithm = cli
          .promptIndexedOptions("Please select algorithm", algorithmViews)
          .getAlgorithm();
      Algorithm algorithm =
          AlgorithmFactory.create(selectedAlgorithm);

      // User specifies quantum when simulating round robin
      if (selectedAlgorithm == AlgorithmEnum.ROUND_ROBIN) {
        int quantum = cli.promptInt("Please specify quantum time");
        RoundRobin rr = (RoundRobin) algorithm;
        rr.setQuantum(quantum);
      }

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
        ProcessView view = new ProcessView(process);
        process.setEventPublisher(publisher);
        publisher.subscribe(ProcessEventEnum.PROGRESS_TIME_UPDATED, view);
        processViews.add(view);
        i++;
      }

      // Create and Run simulation
      Simulation simulation = new Simulation(algorithm, processes);
      SimulationResult result = simulation.run();
      SimulationResultView resultView = new SimulationResultView(result);
      System.out.println(resultView.present());
    }
  }

}
