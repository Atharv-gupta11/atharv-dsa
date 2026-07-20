class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m=triangle.size();
        int n=m;
        int dp[][]=new int[m][n];

        //filling last row
        for(int i=0;i<n;i++){
            dp[m-1][i]=triangle.get(m-1).get(i);
        }

        for(int i=m-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                dp[i][j]=triangle.get(i).get(j) + Math.min(dp[i+1][j],dp[i+1][j+1]);
            }
        }

        
        return dp[0][0];
    }

    int solve(int row, int col, List<List<Integer>> triangle, int[][] dp) {
    if (row >= triangle.size()) {
        return 0;
    }

    if (dp[row][col] != -1) {
        return dp[row][col];
    }

    int down = triangle.get(row).get(col)
            + solve(row + 1, col, triangle, dp);

    int diagonal = triangle.get(row).get(col)
            + solve(row + 1, col + 1, triangle, dp);

    return dp[row][col] = Math.min(down, diagonal);
}
}