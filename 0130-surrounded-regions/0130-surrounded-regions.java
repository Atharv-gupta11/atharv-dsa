class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;

        Queue<int []> q=new LinkedList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O'){
                    if(i==0 || j== 0 || i==m-1 || j==n-1){
                        q.add(new int[]{i,j});
                        board[i][j]='.';
                    }
                }
            }
        }
        int directions[][]={{-1,0},{0,-1},{1,0},{0,1}};

        while(!q.isEmpty()){
            int curr[]=q.remove();

            for(int dir[]:directions){
                int nr=dir[0]+curr[0];
                int nc=dir[1]+curr[1];

                if(nr>=0 && nr<m && nc>=0 && nc<n){
                    if(board[nr][nc]=='O'){
                        board[nr][nc]='.';
                        q.add(new int[]{nr,nc});
                    }
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='.'){
                    board[i][j]='O';
                }
                else{
                    board[i][j]='X';
                }
            }
        }

    }
}