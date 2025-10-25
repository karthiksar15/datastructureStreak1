
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class GeneMutationTry {

    public static void main(String[] args) {

            //String startGene="AACCGGTT";
        // String endGene="AACCGGTA";
        // String[] bank={"AACCGGTA"};
        String startGene="AACCGGTT";
        String endGene="AACCGGTA";
        String[] bank={"AACCGGTA"};
        GeneMutationTry mutationTry=new GeneMutationTry();
        System.out.println("output---->"+mutationTry.minMutation(startGene, endGene, bank));
        
    }
    public int minMutation(String startGene, String endGene, String[] bank) {
        if(bank.length==0) return -1;
    
        Set<String> visited=new HashSet<>();
        Set<String> bankSet = new HashSet<>();
        for(String gene : bank) {
            bankSet.add(gene);
        }
        visited.add(startGene);
        if(startGene.equalsIgnoreCase(endGene) && visited.contains(startGene))
            return 0;

        Deque<Gene> queue=new LinkedList<>();
        queue.add(new Gene(startGene, 0));
        while(!queue.isEmpty())
        {
            Gene temp=queue.remove();
            String geneLable=temp.geneLable;
            int count=temp.count;
            System.out.println("genee---"+geneLable);
            System.out.println("endGene---"+endGene);
            if(geneLable.equalsIgnoreCase(endGene))
            {
                return count;
            }
            
            nextLable(geneLable,count, queue, visited,bankSet);
        }

        return -1;
    }

    public void nextLable(String input,int count,Deque<Gene> queue,Set<String> visited,Set<String> bankSet)
    {
        char[] allowedChars={'A','C','G','T'};
        
        for(int i=0;i<input.length();i++)
        {
            for(char c:allowedChars)
            {
                if(c==input.charAt(i))
                     continue;
                String mut=input.substring(0, i)+c+input.substring(i+1);
                if(!visited.contains(mut) && bankSet.contains(mut))
                {
                    queue.add(new Gene(mut, count+1));
                    visited.add(mut);
                }
            }
            
        }
        
    }

    class Gene{
        private String geneLable;
        private int count;
        public Gene(String geneLable,int count)
        {
            this.geneLable=geneLable;
            this.count=count;
        }
    }


}

