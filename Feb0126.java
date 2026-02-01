import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Feb0126 {

    public static void main(String[] args) {
        String[] deadends= {"0201","0101","0102","1212","2002"};
        String target="0202";
        Feb0126 feb=new Feb0126();
        System.out.println("openLock---->"+feb.openLock(deadends, target));
    }

      public int openLock(String[] deadends, String target) {
        Set<String> dict=new HashSet<>(Arrays.asList(deadends));
        if(dict.contains(target)) return  -1;
        String start="0000";
        Set<String> visited=new HashSet<>();
        Deque<Pair> queue=new LinkedList<>();
        queue.add(new Pair(start, 0));
        visited.add(start);
        while(!queue.isEmpty())
        {
            Pair tempObj=queue.poll();
            String temp=tempObj.node;
            int score=tempObj.steps;
            if(temp.equals(target)) return  score;

            for(String str:findNeighbour(temp))
            {
                if(visited.add(str) && (!dict.contains(str)))
                {
                    queue.add(new Pair(str, score+1));
                }
              
            }
        }
        
        return -1;
      }

      public List<String> findNeighbour(String src)
      {
        List<String> list=new ArrayList<>();
        for(int i=0;i<src.length();i++)
        {
            int num=src.charAt(i)-'0';
            for(int index:List.of(-1,1))
            {
                int temp=((num+index)+10)%10;
                String res=src.substring(0, i)+temp+src.substring(i+1);
                list.add(res);
            }
        }
        return list;
      }

class Pair {
    String node;
    int steps;
    Pair(String node, int steps) {
        this.node = node;
        this.steps = steps;
    }
}
    
}
