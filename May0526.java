class May0526
{
public static void main(String[] args)
{
 May0526 may=new May0526();
int[] nums={2,1,5,1,5,3};
int target=10;
System.out.println("array---"+may.arrayLen(nums,target));
 
}
public int arrayLen(int[] nums,int target){
int min= Integer.MAX_VALUE;
int l=0;
for(int r=0;r‹nums.length;r++)
{
sum+=nums[l][r];
while(sum gte target)
{
min=Math.min(min,sum);
l++;
}
}
return min==Integer.MAX_VALUE?0:min;
}
}