package no.ntnu.stud.views;

public class AsciiArtView {
  public void greet() {
    System.out.print("""
  ____ ____  _   _ ____       _              _       _
 / ___|  _ \\| | | / ___|  ___| |__   ___  __| |_   _| | ___ _ __
| |   | |_) | | | \\___ \\ / __| '_ \\ / _ \\/ _` | | | | |/ _ | '__|
| |___|  __/| |_|  ___) | (__| | | |  __| (_| | |_| | |  __| |
 \\____|_|    \\___/|____/ \\___|_| |_|\\___|\\__,_|\\__,_|_|\\___|_|

    """);
    System.out.println("The Epic Process Simulator");
  }


  public void goodbye() {
    System.out.println("Have a nice day!");
  }

}
