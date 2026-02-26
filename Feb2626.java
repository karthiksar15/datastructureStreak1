public class sliding {

    public static void main(String[] args) {
        sliding slid=new sliding();
        int[] arr={5,1,2,3,7};
        int k=3;
        System.out.println("max-->"+slid.maxSum(arr, k));
        
    }

    public int maxSum(int[] arr,int k)
    {
        int m=0;
        int n=arr.length;
        int result=0;
        while(m!=k)
        {
            int sum=0;
            for(int i=n-1;i>=n-k+m;i--)
            {
                sum+=arr[i];
            }
            for(int j=0;j<m;j++)
            {
                sum+=arr[j];
            }
            result=Math.max(result,sum);
            m++;
        }
        return result;
    }
    
}
