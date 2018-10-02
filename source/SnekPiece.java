public class SnekPiece {
	int posX;
	int posY;
	char body;
	boolean isActive;

	public SnekPiece(int posX, int posY, char body) {
		this.posX = posX;
		this.posY = posY;
		this.body = body;
		this.isActive = false;
	}

	public void activate() {
		isActive = true;
	}
}
