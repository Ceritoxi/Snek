public class Snek {

	boolean isAlive;
	int speed;
	int score;
	int size;
	int direction;
	SnekPiece[] snek;

	public Snek() {
		isAlive = true;
		this.speed = 1;
		this.size = 0;
		this.score = 0;
		this.direction = 1;
		snek = new SnekPiece[2501];
		snek[this.size] = new SnekPiece(3, 3, (char) 62);
		snek[this.size].isActive = true;
	}

	public SnekPiece getSnekPiece(int index) {
		return snek[index];
	}

	public SnekPiece head() {
		return snek[0];
	}

	public int commandSnek(InputThread inputThread) {
		int directionBuffer;
		switch (inputThread.input) {
		case "w":
		case "W":
		case "8":
			directionBuffer = direction;
			if (/* (0 + 2) % 4 */2 != directionBuffer) {
				direction = 0;
			}
			break;
		case "a":
		case "A":
		case "4":
			directionBuffer = direction;
			if (/* (0 + 2) % 4 */1 != directionBuffer) {
				direction = 3;
			}
			break;
		case "s":
		case "S":
		case "2":
			directionBuffer = direction;
			if (/* (0 + 2) % 4 */0 != directionBuffer) {
				direction = 2;
			}
			break;
		case "d":
		case "D":
		case "6":
			directionBuffer = direction;
			if (/* (0 + 2) % 4 */3 != directionBuffer) {
				direction = 1;
			}
			break;
		case " ":
			if (speed < 8) {
				speed++;
				inputThread.input = "";
			}
		}
		return direction;
	}

	public void snekDies() {
		isAlive = false;
	}

	public void snekEats(Food food) {
		this.size++;
		score += food.nutritionalValue;
		snek[this.size] = new SnekPiece(snek[this.size - 1].posX, snek[this.size - 1].posY, snek[this.size - 1].body);
	}

	public void snekMoves() {
		// 0-up, 1-right, 2-down, 3-left
		for (int i = this.size; i >= 1; i--) {
			if (snek[i].isActive) {
				snek[i].posX = snek[i - 1].posX;
				snek[i].posY = snek[i - 1].posY;
				snek[i].body = snek[i - 1].body;
			}
		}
		switch (direction) {
		case 0:
			snek[0].posX--;
			snek[0].body = (char) 94;
			break;
		case 1:
			snek[0].posY++;
			snek[0].body = (char) 62;
			break;
		case 2:
			snek[0].posX++;
			snek[0].body = (char) 118;
			break;
		case 3:
			snek[0].posY--;
			snek[0].body = (char) 60;
		}

		snek[this.size].activate();

	}
}
