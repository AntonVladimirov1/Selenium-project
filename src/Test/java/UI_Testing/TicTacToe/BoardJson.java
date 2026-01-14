package UI_Testing.TicTacToe;

public class BoardJson {


    public static String from(TicTacToe game) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"board\":[");

        for (int i = 0; i < 3; i++) {
            sb.append("[");
            for (int j = 0; j < 3; j++) {
                sb.append("\"").append(game.board[i][j]).append("\"");
                if (j < 2) sb.append(",");
            }
            sb.append("]");
            if (i < 2) sb.append(",");
        }

        sb.append("],");
        sb.append("\"winner\":");
        sb.append(game.getWinner() == null ? "null" : "\"" + game.getWinner() + "\"");
        sb.append("}");

        return sb.toString();
    }
}
