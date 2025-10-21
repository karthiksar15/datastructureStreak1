
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class SnakeAndLadder {

    public static void main(String[] args) {
        SnakeAndLadder snake=new SnakeAndLadder();
        int[][] board={{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}};
        System.out.println("snake--->"+snake.snakesAndLadders(board));
        
        
    }
     public int snakesAndLadders(int[][] board) {
        int n=board.length;
        Pair[] cells=new Pair[n*n+1];
        Integer[] columns=new Integer[n];
        for(int i=0;i<n;i++)
        {
            columns[i]=i;
        }
        int label=1;
        for(int i=n-1;i>=0;i--)
        {
            for(int col:columns)
            {
                    cells[label++]=new Pair(i,col);
            }
            Collections.reverse(Arrays.asList(columns));
        }
        int[] dist=new int[n*n+1];
        Arrays.fill(dist, -1);
        class Vertex implements Comparable<Vertex>
        {
            Integer label;
            Integer distance;
            public Vertex(Integer distance,Integer label)
            {
                this.label=label;
                this.distance=distance;
            }

            @Override
            public int compareTo(Vertex v) {
                return this.distance-v.distance;
            }
            
        
        }
        PriorityQueue<Vertex> pq=new PriorityQueue<>();
        pq.add(new Vertex(0,1));
        dist[1]=0;
        while(!pq.isEmpty())
        {
            Vertex temp=pq.poll();
            int d=temp.distance,curr=temp.label;
            if(d!=dist[curr])
            {
                continue;
            }
            for(int next=curr+1;next<=Math.min(curr+6,n*n);next++)
            {
                int row=cells[next].p1(),column=cells[next].p2();
                int destination=board[row][column]!=-1?board[row][column]:next;
                if(dist[destination]==-1 || dist[curr]+1 < dist[destination])
                {
                    dist[destination]=dist[curr]+1;
                    pq.add(new Vertex(dist[destination],destination));
                }
            }

        }
        return dist[n*n];
        }
        record Pair(int p1,int p2){};
    }

    
