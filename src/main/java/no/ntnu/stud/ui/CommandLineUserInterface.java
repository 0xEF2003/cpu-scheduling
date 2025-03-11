package no.ntnu.stud.ui;

import java.util.List;
import java.util.Scanner;
import no.ntnu.stud.exceptions.StringPresentException;
import no.ntnu.stud.interfaces.Presentable;

public class CommandLineUserInterface {

  /**
   * Prompt any single line input.
   *
   * @param question the prompt to user
   * @return input string
   */
  public String promptInput(String question) {

    // Print question
    System.out.print(question + ": ");

    // Read input
    Scanner stdin = new Scanner(System.in);
    String input = stdin.nextLine();

    return input;
  }


  /**
   * Returns integer from user input.
   *
   * @param question the prompt to user
   * @return integer from input
   */
  public int promptInt(String question) {
    boolean invalidInput = true;
    int number = 0;

    while (invalidInput) {
      try {
        String input = promptInput(question);
        number = Integer.parseInt(input);
        invalidInput = false;
      } catch (NumberFormatException e) {
        System.err.println("Please input numbers only, no spaces.");
      }
    }

    return number;
  }


  /**
   * Type agnostic option selector. Prints all options (auto-indexed) to standard output. Then it
   * asks for index and returns the option corresponding to user input. Yells if bad input.
   *
   * @param <T>     The type of option
   * @param command The prompt to the user
   * @param options The options the user can choose from
   * @return The selected option
   */
  public <T extends Presentable> T promptIndexedOptions(String command, List<T> options) {
    System.out.println();

    int numOptions = options.size();
    T option = options.get(0);
    boolean invalidAnswer = true;

    while (invalidAnswer) {

      // Print selectable options
      for (int i = 0; i < numOptions; i++) {
        int opt = i + 1;
        try {
          String text = options.get(i).present();
          System.out.println("[" + opt + "] " + text);
        } catch (StringPresentException e) {
          continue;
        }
      }

      // Prompt and process input
      System.out.println();
      int i = promptInt(command);

      if (i > 0 && i <= numOptions) {
        invalidAnswer = false;
        option = options.get(i - 1);
      } else { // Complain
        System.err.println("Please select one of the options between 1 and " + numOptions);
      }
    }

    return option;
  }


}
