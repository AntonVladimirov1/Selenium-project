package UI_Testing.TicTacToe;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Main {


    static TicTacToe game = new TicTacToe();

    public static void main(String[] args) throws Exception {

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // HTML page
        server.createContext("/", exchange -> {
            String response = HtmlPage.PAGE;
            exchange.sendResponseHeaders(200, response.getBytes().length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }
        });

        // Move endpoint
        server.createContext("/move", exchange -> {
            String query = exchange.getRequestURI().getQuery(); // row=0&col=1
            int row = Integer.parseInt(query.split("&")[0].split("=")[1]);
            int col = Integer.parseInt(query.split("&")[1].split("=")[1]);

            game.playX(row, col);

            if (game.getWinner() == null) {
                int[] botMove = Bot.bestMove(game); // optional
                game.playO(botMove[0], botMove[1]);
            }

            String response = gameState();
            exchange.sendResponseHeaders(200, response.getBytes().length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }
        });

        server.start();
        System.out.println("Open http://localhost:8080");
    }

    static String gameState() {
        return BoardJson.from(game);
    }
}
