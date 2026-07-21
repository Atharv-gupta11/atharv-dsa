class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        int n=nums.length;
        for(int x:nums)sum+=x;
        Boolean dp[][]=new Boolean[n][sum+1];
        
        return solve(nums,0,sum,0,dp);
    }

    boolean solve(int []nums , int idx ,int totsum ,int currsum,Boolean dp[][]){
        if(totsum-currsum < currsum)return false;
        if(totsum-currsum==currsum)return true;

        if(idx>=nums.length)return false;

        if(dp[idx][currsum]!=null)return dp[idx][currsum];
        //take
        boolean t = solve(nums , idx+1 ,totsum , currsum + nums[idx],dp);
        boolean nt = solve(nums , idx+1 ,totsum , currsum,dp);

        return dp[idx][currsum]=t || nt;
    }
}