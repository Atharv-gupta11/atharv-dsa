class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1)return nums[0];
        //take
        int op1=rob(nums,0,n-2);
        int op2=rob(nums,1,n-1);

        return Math.max(op1,op2);
        
    }

    


    public int rob(int[] nums,int s,int e) {
        int n=e-s+1;

        int a=nums[s];
        if(n==1)return a;
        int b=Math.max(nums[s],nums[s+1]);
        if(n==2)return b;
        
        int c=-1;
        for(int i=s+2;i<=e;i++){
            c=Math.max(b,a+nums[i]);
            a=b;
            b=c;
        }

        return c;
    }
}