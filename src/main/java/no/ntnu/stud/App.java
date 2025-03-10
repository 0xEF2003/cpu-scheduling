package no.ntnu.stud;

import no.ntnu.stud.ui.CommandLineUserInterface;
import no.ntnu.stud.views.AlgorithmView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import no.ntnu.stud.enums.Algorithm;

/**
 * Hello world!
 *
 */
public class App {
    private boolean running;
    private CommandLineUserInterface cli;

    public App() {
        this.cli = new CommandLineUserInterface();
    }

    public void start()
    {
        cli.greet();
        this.mainLoop();
        cli.goodbye();
    }

    private void mainLoop() {
        if (running) { return; }
        running = true;

        while (running) {

            // Get list of all supported algorithms
            List<AlgorithmView> algorithms = Stream.of(Algorithm.values())
                .map(AlgorithmView::new)
                .collect(Collectors.toList());

            // User selects one of the available algorithms
            AlgorithmView selected = cli.promptIndexedOptions("Please select algorithm", algorithms);
        }
    }
}
