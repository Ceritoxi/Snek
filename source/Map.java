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
}
