import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Bomb {

    public static void main(String[] args) {
        Bomb bomb = new Bomb();
        int[][] bombs = { { 1, 2, 3 }, { 2, 3, 1 }, { 3, 4, 2 }, { 4, 5, 3 }, { 5, 6, 4 } };
        System.out.println("Bomb maximum---->" + bomb.maximumDetonation(bombs));
    }

    public int maximumDetonation(int[][] bombs) {

         Map<Integer,List<Integer>> map=new HashMap<>();        
         

        for(int i=0;i<bombs.length;i++)
        {
            for(int j=0;j<bombs.length;j++)
            {

                if(i==j) continue;
                int xi=bombs[i][0];
                int yi=bombs[i][1];
                int radius=bombs[i][2];
                int xj=bombs[j][0];
                int yj=bombs[j][1];
                long leftEqn= radius * radius;
                long rightEqn=((xi-yi)*(xi-yi)) + ((xj-yj)*(xj-yj));
                if(leftEqn>=rightEqn)
                    map.computeIfAbsent(i, x-> new LinkedList<>()).add(j);
                
            }
        }
        int answer=0;
        for (int i = 0; i < bombs.length; i++) {
            answer = Math.max(answer, dfs(i, map));
        }
        return answer;
    }
    private int dfs(int i,Map<Integer,List<Integer>> graph)
    {
            Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        stack.push(i);
        visited.add(i);
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            for (int neib : graph.getOrDefault(cur, new ArrayList<>())) {
                if (!visited.contains(neib)) {
                    visited.add(neib);
                    stack.push(neib);
                }
            }
        }
        return visited.size();
    }

    class Vertex {
        public int radius;
        public int label;

        public Vertex(int radius, int label) {
            this.radius = radius;
            this.label = label;
        }
    }

}

