import java.util.List;

public class Feb18 {

    public static void main(String[] args) {
        Feb18 feb = new Feb18();
        // List<List<Integer>> rooms = List.of(List.of(1, 3), List.of(3, 0, 1),
        // List.of(2), List.of(0));
        List<List<Integer>> rooms = List.of(List.of(1), List.of(2), List.of(3), List.of());
        System.out.println("can visit-->" + feb.canVisitAllRooms(rooms));
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(rooms, visited, 0);
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i])
                return false;
        }
        return true;
    }

    private void dfs(List<List<Integer>> rooms, boolean[] visited, int room) {
        visited[room] = true;
        for (Integer adj : rooms.get(room)) {
            if (!visited[adj]) {
                dfs(rooms, visited, adj);
            }
        }

    }

}

