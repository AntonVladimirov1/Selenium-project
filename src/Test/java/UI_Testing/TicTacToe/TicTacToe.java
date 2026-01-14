package UI_Testing.TicTacToe;

public class TicTacToe {

    public String[][] board;
    public String winner;

    // constructor
    public TicTacToe() {
        board = new String[3][3];
        winner = null;
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = " ";
            }
        }
    }

    // X move
    public void playX(int row, int col) {
        if (isValidMove(row, col)) {
            board[row][col] = "X";
            checkWinner();
        }
    }

    // O move
    public void playO(int row, int col) {
        if (isValidMove(row, col)) {
            board[row][col] = "O";
            checkWinner();
        }
    }

    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 &&
                col >= 0 && col < 3 &&
                board[row][col].equals(" ") &&
                winner == null;
    }

    private void checkWinner() {
        // rows & columns
        for (int i = 0; i < 3; i++) {
            if (!board[i][0].equals(" ") &&
                    board[i][0].equals(board[i][1]) &&
                    board[i][1].equals(board[i][2])) {
                winner = board[i][0];
                return;
            }

            if (!board[0][i].equals(" ") &&
                    board[0][i].equals(board[1][i]) &&
                    board[1][i].equals(board[2][i])) {
                winner = board[0][i];
                return;
            }
        }

        // diagonals
        if (!board[0][0].equals(" ") &&
                board[0][0].equals(board[1][1]) &&
                board[1][1].equals(board[2][2])) {
            winner = board[0][0];
            return;
        }

        if (!board[0][2].equals(" ") &&
                board[0][2].equals(board[1][1]) &&
                board[1][1].equals(board[2][0])) {
            winner = board[0][2];
        }
    }

    public String getWinner() {
        return winner;
    }

    public boolean isCellEmpty(int row, int col) {
        return board[row][col].equals(" ");
    }


}
