class Solution {
    public int lengthOfLIS(int[] nums) {
        int n= nums.length;
        int dp[][] = new int [n+1][n+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                dp[i][j]=-1;
            }
        }
        return solve(nums , 0 , -1 , dp);
    }

    int solve(int nums[] , int idx, int last, int dp[][]){
        if(idx>=nums.length)return 0;
        
        if(dp[idx][last+ 1]!=-1)return dp[idx][last+ 1];

        int skip = solve(nums,idx+1 , last , dp);
        
        int take = 0;
        if (last == -1 || nums[idx] > nums[last]) {
            take = 1 + solve(nums, idx + 1, idx , dp);
        }

        return dp[idx][last + 1]=Math.max(skip , take);
    }
}