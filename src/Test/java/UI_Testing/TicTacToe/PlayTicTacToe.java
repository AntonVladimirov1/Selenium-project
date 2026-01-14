package UI_Testing.TicTacToe;

public class PlayTicTacToe {

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();

        game.playX(0, 0);
        game.playO(1, 1);
        game.playX(0, 1);
        game.playO(2, 2);
        game.playX(0, 2);

        System.out.println("Winner: " + game.getWinner()); // X
    }
}
