class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int dp[][]=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                dp[i][j]=-1;
            }
        }
        return (int)solve(0,0,m,n,grid,dp);
    }

    long solve(int x,int y,int m,int n,int [][]grid,int dp[][]){
        if(x>=m || y>=n)return Integer.MAX_VALUE;

        if(x==m-1 && y==n-1){
            return grid[x][y];
        }
        if(dp[x][y]!=-1)return (long)dp[x][y];

        long b=grid[x][y]+solve(x+1,y,m,n,grid,dp);
        long r=grid[x][y]+solve(x,y+1,m,n,grid,dp);

        return dp[x][y]=(int)Math.min(b,r);
    }
}