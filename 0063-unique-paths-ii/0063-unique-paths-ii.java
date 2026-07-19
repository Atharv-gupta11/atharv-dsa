class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int dp[][]=new int [m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                dp[i][j]=-1;
            }
        }
        return solve(0,0,obstacleGrid,m,n,dp);
    }

    int solve(int x,int y,int [][]grid,int m,int n, int dp[][] ){
        if(x>=m || y>=n)return 0;
        if(grid[x][y]==1)return 0;
        if(x==m-1 && y==n-1){
            return 1;
        }

        if(dp[x][y]!=-1)return dp[x][y];

        int r=solve(x,y+1,grid,m,n,dp);
        int d=solve(x+1,y,grid,m,n,dp);

        return dp[x][y]=r+d;
    }
}