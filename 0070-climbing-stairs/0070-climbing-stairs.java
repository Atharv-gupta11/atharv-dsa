class Solution {
    public int climbStairs(int n) {
        int ways[]=new int[n+1];
        for(int i=0;i<=n;i++)ways[i]=-1;
        return solve(0,ways,n);
    }

    int solve(int curr,int ways[],int target){
        if(curr>target)return 0;
        if(curr==target)return 1;

        if(ways[curr]!=-1)return ways[curr];

        int a=solve(curr+1,ways,target);
        int b=solve(curr+2,ways,target);

        return ways[curr]=a+b;
    }
}