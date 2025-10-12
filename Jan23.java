import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.Map.Entry;
import java.util.Queue;

public class Jan31 {

    public static void main(String[] args) {
        Jan31 jan = new Jan31();
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 3, 1 }, { 4, 0 }, { 5, 0 }, { 5, 6 } };
        int[] restricted = { 4, 5 };
        System.out.println("test----" + jan.reachableNodes(7, edges, restricted));

    }

    public int reachableNodes(int n, int[][] edges, int[] restricted) {

        Set<Integer> seen = new HashSet<>();
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            adjList.computeIfAbsent(edges[i][0], k -> new ArrayList<>()).add(edges[i][1]);
            adjList.computeIfAbsent(edges[i][1], k -> new ArrayList<>()).add(edges[i][0]);
        }
        for (int node : restricted) {
            seen.add(node);
        }
        int ans = 0;
        seen.add(0);
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(0));

        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            ans++;

            // For all the neighbors of the current node, if we haven't visit it before,
            // add it to 'queue' and mark it as visited.
            for (int nextNode : adjList.get(currNode)) {
                if (!seen.contains(nextNode)) {
                    seen.add(nextNode);
                    queue.offer(nextNode);
                }
            }
        }

        return ans;

    }

}
