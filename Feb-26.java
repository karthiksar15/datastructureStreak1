import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Feb26 {

    public static void main(String[] args) {
        int n = 7;
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 3, 1 }, { 4, 0 }, { 0, 5 }, { 5, 6 } };
        int[] restricted = { 4, 5 };
        Feb26 feb = new Feb26();
        System.out.println("febbb---->" + feb.reachableNodes(n, edges, restricted));
    }

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        if (edges.length == 0)
            return 0;
        Map<Integer, List<Integer>> adjList = new HashMap();
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < edges.length; i++) {
            adjList.computeIfAbsent(edges[i][0], k -> new ArrayList<>()).add(edges[i][1]);
            adjList.computeIfAbsent(edges[i][1], k -> new ArrayList<>()).add(edges[i][0]);
        }
        int count = 1;
        for (int i = 0; i < restricted.length; i++) {
            seen.add(restricted[i]);
        }
        Deque<Integer> stack = new LinkedList<>();
        stack.add(0);
        seen.add(0);
        while (!stack.isEmpty()) {
            Integer temp = stack.pollFirst();
            for (Integer vertex : adjList.get(temp)) {
                if (!seen.contains(vertex)) {
                    seen.add(vertex);
                    stack.push(vertex);
                    count++;
                }
            }
        }
        return count;
    }

}

