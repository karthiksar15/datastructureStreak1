import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Jump {

    public static void main(String[] args) {

       // int[] arr={4,2,3,0,3,1,2};
        int[] arr={3,0,2,1,2};
        //int start=5;
        int start=2;
        //int start=0;
        Jump jump=new Jump();
        System.out.println("can reach---"+jump.canReach(arr, start));
        
    }

    public boolean canReach(int[] arr, int start) {

        Set<Integer> visited=new HashSet<>();
        Deque<Integer> queue=new LinkedList<>();
        int[] condition=new int[]{1,-1};
        queue.add(start);
        visited.add(start);
        int init=0;
        int end=arr.length;
        while(!queue.isEmpty())
        {
            Integer popped=queue.poll();
            if(popped>=init && popped<end && arr[popped]==0)
            {
                return true;
            }
            for(int i=0;i<condition.length;i++)
            {
                    int num=popped+(arr[popped]*condition[i]);
                    if(num>=init && num<end && (!visited.contains(num)))
                    {
                        queue.add(num);
                        visited.add(num);
                    }
            }
        }
        return false;
        
        
    }



}

