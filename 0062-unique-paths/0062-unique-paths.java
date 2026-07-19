class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                dp[i][j]=-1;
            }
        }
        return solve(0,0,m,n,dp);
    }

    int solve(int x , int y , int  m ,int n , int dp[][]){
        if(x<0 || x>=m || y>=n || y<0){
            return 0;
        }
        if(x==m-1 && y==n-1)return 1;

        if(dp[x][y]!=-1)return dp[x][y];
        
        int right = solve(x,y+1,m,n,dp);
        
        int dwn=solve(x+1,y,m,n,dp);
        
        return dp[x][y]=right+dwn;
    }
}