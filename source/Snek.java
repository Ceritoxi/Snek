public class Snek {

    boolean isAlive;
    int speed;
    int score;
    int size;
    SnekPiece[] snek;

    public Snek(int speed) {
        isAlive = true;
        this.speed = speed;
        this.size = 0;
        this.score = 0;
        snek = new SnekPiece[2501];
        snek[this.size] = new SnekPiece(3, 3, (char)62);
        snek[this.size].isActive = true;
    }

    public void snekDies() {
        isAlive = false;
    }

    public void snekEats(int nutritionalValue) {
        this.size++;
        score += nutritionalValue;
        snek[this.size] = new SnekPiece(snek[this.size - 1].posX, snek[this.size - 1].posY, snek[this.size - 1].body);
    }

    public void snekMoves(int direction) {
        //0-up, 1-right, 2-down, 3-left
        for (int i = this.size; i >= 1; i--) {
            if (snek[i].isActive) {
                snek[i].posX = snek[i - 1].posX;
                snek[i].posY = snek[i - 1].posY;
                snek[i].body = snek[i - 1].body;
            }
        }
        switch(direction) {
            case 0:
                snek[0].posX--;
                snek[0].body = (char)94;
                break;
            case 1:
                snek[0].posY++;
                snek[0].body = (char)62;
                break;
            case 2:
                snek[0].posX++;
                snek[0].body = (char)118;
                break;
            case 3:
                snek[0].posY--;
                snek[0].body = (char)60;
        }

        snek[this.size].activate();

    }
}
