class Solution {
    public int numIslands(char[][] grid) {
        int cnt=0;

        int m=grid.length;
        int n=grid[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j,m,n);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    void dfs(char [][] grid,int r, int c, int m ,int n){
        if(r>m || r<0 || c>n || c<0)return;

        int directions[][]={{-1,0},{0,-1},{1,0},{0,1}};

        grid[r][c]='2';

        for(int dir[]: directions){
            int nr=r+dir[0];
            int nc=c+dir[1];

            if(nr>=0 && nr<m && nc>=0 && nc<n){
                if(grid[nr][nc]=='1'){
                    grid[nr][nc]='2';
                    dfs(grid,nr,nc,m,n);
                }
            }
        }
    }
}