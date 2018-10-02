import java.io.IOException;

public class GameLoop {

	Snek snek;
	Map map;
	Food food;

	public final String os;

	public GameLoop(final String os) {
		this.os = os;
	}

	public void startGame(InputThread inputThread) throws InterruptedException {
		this.snek = new Snek();
		this.map = new Map();
		this.food = Food.randomFood(map);

		while (snek.isAlive) {

			map.reset();
			snek.commandSnek(inputThread);
			snek.snekMoves();
			map.settleFood(food);

			map.placeSnek(snek);

			if (snekHeadIsOnFood()) {
				snek.snekEats(food);
				food = Food.randomFood(map);
				food.setFoodBasedOnSnek(snek);

			} else if (snekHeadIsNotOnEmptyField()) {
				gameOver(inputThread);
			}

			map.setMapPart(snek.head());

			cls();

			map.draw();

			System.out.println("Score: " + snek.score + "\t\t Speed: " + snek.speed);

			wait(500 - 50 * snek.speed);
		}
	}

	private void gameOver(InputThread inputThread) {
		snek.snekDies();
		inputThread.runSign = snek.isAlive;
		System.out.println("You fucked up");
	}

	private boolean snekHeadIsNotOnEmptyField() {
		return map.getMapPart(snek.head().posX, snek.head().posY) != ' ';
	}

	private boolean snekHeadIsOnFood() {
		return map.getMapPart(snek.head().posX, snek.head().posY) == food.body;
	}

	private void cls() {
		if (os.contains("Windows")) {
			try {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} catch (InterruptedException | IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				Runtime.getRuntime().exec("clear");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void wait(int k) {
		long time0, time1;
		time0 = System.currentTimeMillis();
		do {
			time1 = System.currentTimeMillis();
		} while ((time1 - time0) < k);
	}

}
