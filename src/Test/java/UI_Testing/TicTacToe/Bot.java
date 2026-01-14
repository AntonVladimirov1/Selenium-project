package UI_Testing.TicTacToe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bot {


    private static final Random random = new Random();

    public static int[] bestMove(TicTacToe game) {
        List<int[]> free = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (game.isCellEmpty(i, j)) {
                    free.add(new int[]{i, j});
                }
            }
        }

        return free.get(random.nextInt(free.size()));
    }
}
