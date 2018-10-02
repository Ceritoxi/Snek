public class Food {
	int posX;
	int posY;
	char body;
	int nutritionalValue;

	public Food(int posX, int posY, char body, int nutritionalValue) {
		this.posX = posX;
		this.posY = posY;
		this.body = body;
		this.nutritionalValue = nutritionalValue;
	}

	public static Food randomFood(Map map) {
		return new Food((int) (Math.random() * (map.height - 2) + 1), (int) (Math.random() * (map.width - 2) + 1), 'X',
				1);
	}

	public void setFoodBasedOnSnek(Snek snek) {
		if (snek.size % 5 == 4) {
			this.nutritionalValue = 5 * snek.speed;
			this.body = '$';
		} else {
			this.nutritionalValue = 1 + snek.speed;
			this.body = 'X';
		}
	}
}
