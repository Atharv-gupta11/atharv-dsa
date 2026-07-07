class Solution {
    int max=0;
    public int rob(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n+1];
        for(int i=0;i<=n;i++)dp[i]=-1;
        return solve(0,nums,dp);
        
    }

    int solve(int idx,int nums[],int dp[]){
        if(idx>=nums.length){
            return 0;
        }

        if(dp[idx]!=-1){
            return dp[idx];
        }
        //rob
        int steal=nums[idx]+solve(idx+2,nums,dp);

        //norob
        int nosteal=solve(idx+1,nums,dp);

        return dp[idx]=Math.max(steal,nosteal);
    }
}