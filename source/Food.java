public class Food {
    int posX;
    int posY;
    char body;
    int nutritionalValue;
    boolean isAlive;

    public Food(int posX, int posY, char body, int nutritionalValue) {
        this.posX = posX;
        this.posY = posY;
        this.body = body;
        this.nutritionalValue = nutritionalValue;
        this.isAlive = true;
    }
}
