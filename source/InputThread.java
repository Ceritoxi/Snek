import java.util.Scanner;

public class InputThread extends Thread{
    /*private final ConsoleSnek consoleSnek;
    public InputThread(ConsoleSnek consoleSnek) {
        this.consoleSnek = consoleSnek;
    }*/
    String input = "";
    boolean runSign = true;

    public void run() {
        /*Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            // blocks for input, but won't block the server's thread
        }*/
        while (runSign) {
            input = System.console().readLine();
        }
    }

}