package UI_Testing.Antonio;

import java.util.HashMap;
import java.util.Map;

public class Test2 {

    public static boolean isValidSeating(String[][] seating, String[][] disallowedPairs) {
        Map<String, int[]> positionMap = new HashMap<>();

        // Store each student's position
        for (int i = 0; i < seating.length; i++) {
            for (int j = 0; j < seating[i].length; j++) {
                positionMap.put(seating[i][j], new int[]{i, j});
            }
        }

        // Check each disallowed pair
        for (String[] pair : disallowedPairs) {
            String student1 = pair[0];
            String student2 = pair[1];

            int[] pos1 = positionMap.get(student1);
            int[] pos2 = positionMap.get(student2);

            if (pos1 == null || pos2 == null) {
                continue; // or handle as invalid input if needed
            }

            int rowDiff = Math.abs(pos1[0] - pos2[0]);
            int colDiff = Math.abs(pos1[1] - pos2[1]);

            // Adjacent only if up/down/left/right, not diagonal
            if (rowDiff + colDiff == 1) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[][] seating = {
                {"Ezra", "Anika", "Alice", "Hasa"},
                {"Rishi", "Jose", "Clair", "Siena"},
                {"Ayse", "Zeyla", "Layla", "Azan"},
                {"Nayel", "Siafa", "Loren", "Mert"},
                {"Erica", "Hilda", "Harsa", "Joao"},
                {"Lotus", "Nela", "Baro", "Ender"}
        };

        String[][] disallowedPairs1 = {
                {"bob", "bob"},
                {"Layla", "bob"}
        };

        String[][] disallowedPairs2 = {
                {"Nela", "Baro"},
                {"bob", "Ender"}
        };

        System.out.println(isValidSeating(seating, disallowedPairs1)); // false
        System.out.println(isValidSeating(seating, disallowedPairs2)); // true
    }
}
