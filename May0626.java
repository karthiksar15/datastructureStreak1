class May0626{

public static void main(String args[])
{
May0626 may=new May0626();
int[] nums={1,2,1,0,4,2,6};
int size=3;
System.out.println("max---"+maxSlidingWindow(nums,k));
}
public List<Integer> maxSlidingWindow(int[] nums,int k)
{
int l=0,r=0;
List<Integer> list=new ArrayList<>();
int max=Integer.MAX_VALUE;
while(l+r < nums.length)
{
 if(r-l==k)
{
r=l+1;
list.add(max);
max=Integer.MAX_VALUE;
l++;
}
r++;
max=Math.max(max,nums[r]);
}
return list;
}
}
}
}