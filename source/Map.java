public class Map {

	char[][] map;
	public final int height = 25;
	public final int width = 50;

	public Map() {
		map = new char[height][width];
		reset();
	}

	public void placeSnek(Snek snek) {
		for (int i = 1; i <= snek.size; i++) {
			setMapPart(snek.snek[i].posX, snek.snek[i].posY, snek.snek[i].body);
		}
	}

	public void reset() {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				map[i][j] = ' ';
			}
		}
		for (int i = 0; i < width; i++) {
			map[0][i] = '_';
			map[height - 1][i] = '_';
		}

		for (int i = 0; i < height; i++) {
			map[i][0] = '|';
			map[i][width - 1] = '|';
		}
	}

	public void draw() {
		for (int i = 0, mapLength = this.map.length; i < mapLength; i++) {
			char[] mapRow = this.map[i];
			for (int i1 = 0, mapRowLength = mapRow.length; i1 < mapRowLength; i1++) {
				char mapPiece = mapRow[i1];
				System.out.print(mapPiece);
			}
			printInformationalStuff(i);
		}
	}

	public void setMapPart(int index, int jndex, char data) {
		this.map[index][jndex] = data;
	}

	public void setMapPart(SnekPiece snekPiece) {
		this.map[snekPiece.posX][snekPiece.posY] = snekPiece.body;
	}

	public void settleFood(Food food) {
		setMapPart(food.posX, food.posY, food.body);
	}

	public char getMapPart(int index, int jndex) {
		return map[index][jndex];
	}

	private void printInformationalStuff(int i) {
		switch (i) {
		case 4:
			System.out.print("Controls:");
			break;
		case 6:
			System.out.print("\tW\t\t\"Space\" for more difficulty");
			break;
		case 7:
			System.out.print("A\tS\tD\t\"Enter\" to confirm action");
			break;
		case 9:
			System.out.print("Ravel in the beauty of this dynamic duo: Console & Seizure");
			break;
		case 10:
			System.out.print("LIVE THE DREAM");
		}
		System.out.print("\n");
	}

	/**
	 * Gargantuan and ugly, just the way I love it.
	 * 
	 * @return
	 */
	public Map gameOverMap() {
		Map gameOver = this;

		gameOver.map[5][5 + 4] = '#';
		gameOver.map[5][6 + 4] = '#';
		gameOver.map[5][7 + 4] = '#';
		gameOver.map[5][8 + 4] = '#';
		gameOver.map[5][9 + 4] = '#';
		gameOver.map[5][10 + 4] = '#';
		gameOver.map[6][5 + 4] = '#';
		gameOver.map[6][10 + 4] = '#';
		gameOver.map[7][5 + 4] = '#';
		gameOver.map[7][10 + 4] = '#';
		gameOver.map[8][5 + 4] = '#';
		gameOver.map[8][6 + 4] = '#';
		gameOver.map[8][7 + 4] = '#';
		gameOver.map[8][8 + 4] = '#';
		gameOver.map[8][9 + 4] = '#';
		gameOver.map[8][10 + 4] = '#';
		gameOver.map[9][5 + 4] = '#';
		gameOver.map[9][7 + 4] = '#';
		gameOver.map[10][5 + 4] = '#';
		gameOver.map[10][9 + 4] = '#';
		gameOver.map[11][5 + 4] = '#';
		gameOver.map[11][10 + 4] = '#';

		gameOver.map[5][5 + 8 + 4] = '#';
		gameOver.map[5][6 + 8 + 4] = '#';
		gameOver.map[5][7 + 8 + 4] = '#';
		gameOver.map[5][8 + 8 + 4] = '#';
		gameOver.map[5][9 + 8 + 4] = '#';
		gameOver.map[5][10 + 8 + 4] = '#';
		gameOver.map[6][5 + 8 + 4] = '#';
		gameOver.map[7][5 + 8 + 4] = '#';
		gameOver.map[8][5 + 8 + 4] = '#';
		gameOver.map[8][6 + 8 + 4] = '#';
		gameOver.map[8][7 + 8 + 4] = '#';
		gameOver.map[8][8 + 8 + 4] = '#';
		gameOver.map[8][9 + 8 + 4] = '#';
		gameOver.map[8][10 + 8 + 4] = '#';
		gameOver.map[9][5 + 8 + 4] = '#';
		gameOver.map[10][5 + 8 + 4] = '#';
		gameOver.map[11][5 + 8 + 4] = '#';
		gameOver.map[11][6 + 8 + 4] = '#';
		gameOver.map[11][7 + 8 + 4] = '#';
		gameOver.map[11][8 + 8 + 4] = '#';
		gameOver.map[11][9 + 8 + 4] = '#';
		gameOver.map[11][10 + 8 + 4] = '#';

		gameOver.map[5][5 + 16 + 4] = '#';
		gameOver.map[5][10 + 16 + 4] = '#';
		gameOver.map[6][5 + 16 + 4] = '#';
		gameOver.map[6][9 + 16 + 4] = '#';
		gameOver.map[7][5 + 16 + 4] = '#';
		gameOver.map[7][7 + 16 + 4] = '#';
		gameOver.map[8][5 + 16 + 4] = '#';
		gameOver.map[8][6 + 16 + 4] = '#';
		gameOver.map[9][5 + 16 + 4] = '#';
		gameOver.map[9][7 + 16 + 4] = '#';
		gameOver.map[10][5 + 16 + 4] = '#';
		gameOver.map[10][9 + 16 + 4] = '#';
		gameOver.map[11][5 + 16 + 4] = '#';
		gameOver.map[11][10 + 16 + 4] = '#';

		gameOver.map[5][5 + 24 + 4] = '#';
		gameOver.map[5][6 + 24 + 4] = '#';
		gameOver.map[5][7 + 24 + 4] = '#';
		gameOver.map[5][8 + 24 + 4] = '#';
		gameOver.map[5][9 + 24 + 4] = '#';
		gameOver.map[5][10 + 24 + 4] = '#';
		gameOver.map[5][11 + 24 + 4] = '#';
		gameOver.map[6][8 + 24 + 4] = '#';
		gameOver.map[7][8 + 24 + 4] = '#';
		gameOver.map[8][8 + 24 + 4] = '#';
		gameOver.map[9][8 + 24 + 4] = '#';
		gameOver.map[10][8 + 24 + 4] = '#';
		gameOver.map[11][8 + 24 + 4] = '#';

		return gameOver;
	}
}
