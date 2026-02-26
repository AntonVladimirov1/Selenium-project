package UI_Testing.Antonio;

import UI_Testing.TicTacToe.Main;

public class Test {

    public static String reversEachWord (String input) {
        String[] words = input.split(" ");
        String result = "";

        for (String word : words) {
            String reversed = "";
            for (int i = word.length()-1; i >=0; i--) {
                reversed += word.charAt(i);
            }
            result += reversed + " ";
        }
        return result.trim();
    }

    public static void main(String[] args) {
        String input = "I wanna say hi";
        System.out.println(reversEachWord(input));
    }



}
