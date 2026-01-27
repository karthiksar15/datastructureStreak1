import java.util.ArrayList;
import java.util.List;

public class Jan2726 {
    public static void main(String[] args) {
        Jan2726 jan = new Jan2726();
        List<List<Integer>> rooms = List.of(List.of(1, 3), List.of(3, 0, 1), List.of(2), List.of());
        System.out.println("canVissit---->" + jan.canVisitAllRooms(rooms));
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;
        dfs(rooms, 0, visited);
        // for (int i = 0; i < rooms.size(); i++) {
        // if (visited[i])

        // }
        boolean result = true;
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i])
                return false;
        }
        return result;
    }

    public void dfs(List<List<Integer>> rooms, int index, boolean[] visited) {

        for (int i : rooms.get(index)) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(rooms, i, visited);
            }
        }
    }

}
