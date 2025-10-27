import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class WordLadder {

    public static void main(String[] args) {
        WordLadder wl=new WordLadder();
        String beginWord="hit";
        String endWord="cog";
        List<String> wordList=List.of("hot","dot","dog","lot","log","cog");
        System.out.println("ladder length---"+wl.ladderLength(beginWord, endWord, wordList));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Queue<Vertex> queue=new LinkedList<>();
        int L=beginWord.length();

        Map<String,List<String>> allComboDict=new HashMap<>();
        wordList.forEach(word->{
            for(int i=0;i<L;i++)
            {
                String newWord=word.substring(0,i)+'*'+word.substring(i+1);
                List<String> transformations=allComboDict.getOrDefault(newWord, new ArrayList<>());
                transformations.add(word);
                allComboDict.put(newWord, transformations);
            }
        });

        queue.add(new Vertex(beginWord, 1));
         Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while(!queue.isEmpty())
        {
            Vertex temp=queue.poll();
            String word=temp.word;
            int level=temp.distance;
            for(int i=0;i<L;i++)
            {
                String newWord=word.substring(0, i)+'*'+word.substring(i+1);
                for(String adjWord:allComboDict.getOrDefault(newWord,new ArrayList<>()))
                {
                    if(adjWord.equals(endWord))
                    {
                        return level+1;
                    }
                    if(!visited.containsKey(adjWord))
                    {
                        visited.put(adjWord,true);
                        queue.add(new Vertex(adjWord,level+1));
                    }
                }
            }

        }
        return 0;
        
    }

    class Vertex{
        public String word;
        public int distance;
        public Vertex(String word,int distance)
        {
            this.word=word;
            this.distance=distance;
        }
    }



}
