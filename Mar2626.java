import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Mar2626 {

    public static void main(String[] args) {
        Mar2626 mar = new Mar2626();
        char[][] board = { { '1', '2', '.', '.', '3', '.', '.', '.', '.' },
                { '4', '.', '.', '5', '.', '.', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '.', '3' },
                { '5', '.', '.', '.', '6', '.', '.', '.', '4' },
                { '.', '.', '.', '8', '.', '3', '.', '.', '5' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '.', '.', '.', '.', '.', '2', '.', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '8' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
        System.out.println("is it valid-->" + mar.isValidSudoku(board));

    }

    public boolean isValidSudoku(char[][] board) {
        Map<String, Set<Character>> entries = new HashMap<>();
        Map<Integer, Set<Character>> rowEntries = new HashMap<>();
        Map<Integer, Set<Character>> colEntries = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.')
                    continue;
                String key = i / 3 + "#" + j / 3;
                if (entries.computeIfAbsent(key, v -> new HashSet<>()).contains(board[i][j])
                        || rowEntries.computeIfAbsent(i, v -> new HashSet<>()).contains(board[i][j])
                        || colEntries.computeIfAbsent(j, v -> new HashSet<>()).contains(board[i][j]))
                    return false;
                // Set<Character> set = entries.get(key) != null ? entries.get(key) : new
                // HashSet<>();

                entries.get(key).add(board[i][j]);
                rowEntries.get(i).add(board[i][j]);
                colEntries.get(j).add(board[i][j]);
            }
        }
        return true;
    }
}
