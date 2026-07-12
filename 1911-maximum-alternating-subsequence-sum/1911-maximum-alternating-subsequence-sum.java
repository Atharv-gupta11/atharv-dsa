class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n=nums.length;
        long dp[][]=new long[n+1][2];

        for(int i=0;i<=n;i++){
            dp[i][0]=-1;
            dp[i][1]=-1;
        }
        return solve(nums,0,1,dp);
    }

    long solve (int nums[],int idx, int flag,long dp[][]){
        if(idx>=nums.length)return 0;

        int col = (flag == 1) ? 1 : 0;

        if (dp[idx][col] != -1) return dp[idx][col];
            
        long skip = solve(nums ,idx+ 1 , flag, dp);

        long take= flag*nums[idx] + solve(nums ,idx+1, -1*flag, dp);

        return dp[idx][col]=Math.max(skip,take);
    }
}