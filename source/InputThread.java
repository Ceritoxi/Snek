
public class InputThread extends Thread {
	String input = "";
	boolean runSign = true;

	public void run() {
		while (runSign) {
			input = System.console().readLine();
		}
	}

}