import java.io.IOException;

public class ConsoleSnek {

	public static void main(String[] args) throws IOException, InterruptedException {
		final String os = System.getProperty("os.name");
		InputThread inputThread = new InputThread();
		inputThread.start();
		GameLoop gameLoop = new GameLoop(os);
		gameLoop.startGame(inputThread);
	}

}
