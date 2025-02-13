class Solution {
    public int maxNumberOfBalloons(String text) {
       // int[] test = new int[256];
       //  String find = "balloon";
       //  int count = Integer.MAX_VALUE;
       //  for (int i = 0; i < text.length(); i++) {
       //      test[text.charAt(i)-'a']++;
       //  }
       //  int j = 0;
       //  while (j < find.length()) {
       //      int numberOfTimesCharOccured = test[find.charAt(j)];
       //      count = Math.min(numberOfTimesCharOccured, count);
       //      if (numberOfTimesCharOccured > 0)
       //          test[find.charAt(j)]--;
       //      j++;
       //  }
       //  return count;
        int[] test = new int[256];
        String find = "balloon";
        for (int i = 0; i < text.length(); i++) {
            test[text.charAt(i)-'a']++;
        }
        int j = 0;
        int flag=1;
        int count=0;
        while (flag==1) {
                    for(int i=0;i<find.length();i++)
                    {
                        if(test[find.charAt(i)-'a']!=0)
                        {
                            test[find.charAt(i)-'a']--;
                        }else
                        {
                            flag=0;
                            break;
                        }
                    }
                if(flag==1)
                {
                    count++;
                }
        }
        return count;
        
    }
}
