import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Feb01261 {

    public static void main(String[] args) {
     Feb01261 feb=new Feb01261();
     List<List<String>> equations = List.of(List.of("a","b"),List.of("b","c"));
     double[] values = {2.0,3.0};
     List<List<String>> queries = List.of(List.of("a","c"),List.of("b","a"),List.of("a","e"),List.of("a","a"),List.of("x","x"));
     Arrays.stream(feb.calcEquation(equations,values, queries)).forEach(System.out::println);
    }

     public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            Map<String,Map<String,Double>> map=new HashMap<>();
            double[] result=new double[queries.size()];
            int i=0;
            for(List<String> str:equations)
            {
                map.computeIfAbsent(str.get(0), k->new HashMap<>()).put(str.get(1), values[i]);
                map.computeIfAbsent(str.get(1), k->new HashMap<>()).put(str.get(0),1/values[i]);
                i++;
            }
            int j=0;
            for(List<String> query:queries)
            {
                result[j]=findResult(query.get(0),query.get(1),map);
                j++;
            }
            return result;
     }
     private double findResult(String divident,String divisor,Map<String,Map<String,Double>> map)
     {
        if(!map.containsKey(divident)|| (!map.containsKey(divisor))) return  -1;
        double val=-1;
        Set<String> visited=new HashSet<>();
        Deque<Node> queue=new LinkedList<>();
        queue.add(new Node(divident,1.0));
        visited.add(divident);
        while(!queue.isEmpty())
        {
            Node temp=queue.poll();
            String label=temp.val;
            Double ratio=temp.ratio;
                if(label.equals(divisor))
                {
                    return ratio;
                }
                for(Map.Entry<String,Double> entry:map.get(label).entrySet())
                {
                    if(visited.add(entry.getKey()))
                        queue.add(new Node(entry.getKey(),ratio*entry.getValue()));
                }
        }
        
        return val;
     }

     class Node{
        public String val;
        public double ratio;
        public Node(String val,Double ratio)
        {
            this.val=val;
            this.ratio=ratio;
        }
     }
    
}
