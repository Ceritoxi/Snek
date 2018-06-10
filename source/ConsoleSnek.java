public class ConsoleSnek {
    public static void main(String[] args) {
        InputThread inputThread = new InputThread();
        inputThread.start();

        Snek snek = new Snek(1);
        Map map = new Map();
        Food food = new Food((int)(Math.random() * (map.height - 2) + 1), (int)(Math.random() * (map.width - 2) + 1), 'X', 1);

        int directionBuffer = 1;
        int currentDirection = 1;
        while (snek.isAlive) {

            map.reset();

            switch(inputThread.input) {
                case "w":
                case "W":
                case "8":
                    directionBuffer = currentDirection;
                    if (/*(0 + 2) % 4*/2 != directionBuffer) {
                        currentDirection = 0;
                    }
                    break;
                case "a":
                case "A":
                case "4":
                    directionBuffer = currentDirection;
                    if (/*(0 + 2) % 4*/1 != directionBuffer) {
                        currentDirection = 3;
                    }
                    break;
                case "s":
                case "S":
                case "2":
                    directionBuffer = currentDirection;
                    if (/*(0 + 2) % 4*/0 != directionBuffer) {
                        currentDirection = 2;
                    }
                    break;
                case "d":
                case "D":
                case "6":
                    directionBuffer = currentDirection;
                    if (/*(0 + 2) % 4*/3 != directionBuffer) {
                        currentDirection = 1;
                    }
                    break;
                case " ":
                    snek.speed++;
                    inputThread.input = "";
            }

            snek.snekMoves(currentDirection);

            map.map[food.posX][food.posY] = food.body;
            for (int i = 1; i <= snek.size; i++) {
                map.map[snek.snek[i].posX][snek.snek[i].posY] = snek.snek[i].body;
            }

            if (map.map[snek.snek[0].posX][snek.snek[0].posY] == food.body) {
                snek.snekEats(food.nutritionalValue);
                food.posX = (int)(Math.random() * (map.height - 2) + 1);
                food.posY = (int)(Math.random() * (map.width - 2) + 1);
                if (snek.size % 5 == 4) {
                    food.nutritionalValue = 5 * snek.speed;
                    food.body = '$';
                } else {
                    food.nutritionalValue = 1 + snek.speed;
                    food.body = 'X';
                }
            } else if (map.map[snek.snek[0].posX][snek.snek[0].posY] != ' ') {
                snek.snekDies();
                inputThread.runSign = snek.isAlive;
                System.out.println("You fucked up");
            }

            map.map[snek.snek[0].posX][snek.snek[0].posY] = snek.snek[0].body;

            draw(map.map);
            System.out.println("Score: " + snek.score + "\t\t Speed: " + snek.speed);
            wait(500 - 50 * snek.speed);
        }
    }

    private static void draw(char[][] map) {
        /*for (char[] mapRow : map) {
            for (char mapPiece : mapRow) {
                System.out.print(mapPiece);
            }
            System.out.print("\n");
        }*/
		for (int i = 0, mapLength = map.length; i < mapLength; i++) {
            char[] mapRow = map[i];            
            for (int i1 = 0, mapRowLength = mapRow.length; i1 < mapRowLength; i1++) {
                char mapPiece = mapRow[i1];
                System.out.print(mapPiece);
            }
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
		cls();
    }

    private static void cls() {
        for (int i = 0; i < 3; i++) {
            System.out.print("\n");
        }
    }

    public static void wait (int k){
        long time0, time1;
        time0 = System.currentTimeMillis();
        do{
            time1 = System.currentTimeMillis();
        } while ((time1 - time0) < k);
    }
}



