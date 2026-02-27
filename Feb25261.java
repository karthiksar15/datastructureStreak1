
import java.util.PriorityQueue;

public class Feb2526 {

    public static void main(String[] args) {
        
    }

    public int shortestPath(int[][] grid,int k)
    {
        if(grid[0][0]==1 && k==1) return -1;
        int R=grid.length;
        int C=grid[0].length;
        int sum=(R-1)+(C-1);
        if(k>=sum)
        {
            return sum; 
        }
        return astar(grid,k);
    }

    public int astar(int[][] grid,int k)
    {
        int R=grid.length;
        int C=grid[0].length;
         PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[0], b[0]));
         int dis=heuristic(0, 0, R-1, C-1);
         pq.add(new int[]{dis,0,0,0,k-grid[0][0]});
         int[] sr={0,0,-1,1};
         int[] sc={1,-1,0,0};
         int[][] best=new int[R][C];
         for(int i=0;i<R;i++)
         {
            for(int j=0;j<C;j++)
            {
                best[i][j]=-1;
            }
         }
         best[0][0]=k-grid[0][0];
         while(!pq.isEmpty())
         {
            int[] temp=pq.poll();
            int or=temp[1];
            int oc=temp[2];
            int od=temp[3];
            int orem=temp[4];
            if(or==R-1 && oc==C-1) return od;
            for(int i=0;i<sr.length;i++)
            {
                int nr=or+sr[i];
                int nc=oc+sc[i];
              
                if((nr<0 && nr>R) || (nc<0 && nc>C) ) continue;
                if(best[nr][nc]>=k) continue;
                int nrem=orem-grid[nr][nc];
                if(nrem<0) continue;
                int nhr=heuristic(nr, nc, R-1, C-1);
                int nf=nrem+nhr;
                pq.add(new int[]{nf,nr,nc,od+1,nrem});
            }
         }
         return -1;
    }
    public int heuristic(int r,int c,int r1,int c1)
    {
        return Math.abs(r-r1)+Math.abs(c-c1);
    }


    
}
