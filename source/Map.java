public class Map {

    char[][] map;
    public final int height = 25;
    public final int width = 50;

    public Map() {
        map = new char[height][width];
        reset();

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
}
