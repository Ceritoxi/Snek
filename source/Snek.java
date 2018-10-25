public class Snek {

    boolean isAlive;
    int speed;
    int score;
    int size;
    Direction direction;
    SnekPiece[] snek;

    public Snek() {
        isAlive = true;
        this.speed = 1;
        this.size = 0;
        this.score = 0;
        this.direction = Direction.right;
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

    public void commandSnek(InputThread inputThread) {
        if (ourInputIs(inputThread, "w", "W", "8")) {
            directSnek(Direction.up);
        }
        if (ourInputIs(inputThread, "a", "A", "4")) {
            directSnek(Direction.left);
        }
        if (ourInputIs(inputThread, "s", "S", "2")) {
            directSnek(Direction.down);
        }
        if (ourInputIs(inputThread, "d", "D", "6")) {
            directSnek(Direction.right);
        }
        if (ourInputIs(inputThread, " ")) {
            speedSnekUp(inputThread);
        }
    }

    private boolean ourInputIs(InputThread inputThread, String... input) {
        for (String c : input) {
            if (inputThread.input.equals(c)) {
                return true;
            }
        }
        return false;
    }

    private void speedSnekUp(InputThread inputThread) {
        if (speed < 8) {
            speed++;
            inputThread.input = "";
        }
    }

    private void directSnek(Direction direction) {
        if ((this.direction.ordinal() + 2) % 4 != direction.ordinal()) {
            this.direction = direction;
        }
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
        for (int i = this.size; i >= 1; i--) {
            if (snek[i].isActive) {
                snek[i].posX = snek[i - 1].posX;
                snek[i].posY = snek[i - 1].posY;
                snek[i].body = snek[i - 1].body;
            }
        }
        switch (direction) {
        case up:
            snek[0].posX--;
            snek[0].body = (char) 94;
            break;
        case right:
            snek[0].posY++;
            snek[0].body = (char) 62;
            break;
        case down:
            snek[0].posX++;
            snek[0].body = (char) 118;
            break;
        case left:
            snek[0].posY--;
            snek[0].body = (char) 60;
        }

        snek[this.size].activate();

    }

    enum Direction {
        up, right, down, left
    }
}
