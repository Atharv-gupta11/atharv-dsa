class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;

        int ans[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans[i][j]=-1;
            }
        }   


        Queue<int []> q=new LinkedList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j});
                    ans[i][j]=0;
                }
            }
        } 

        int directions[][]={{-1,0},{0,-1},{1,0},{0,1}};
        while(!q.isEmpty()){
            int curr[]=q.remove();

            for(int dir[]:directions){
                int nr=curr[0]+dir[0];
                int nc=curr[1]+dir[1];

                if(nr>=0 && nr<m && nc>=0 && nc<n){
                    if(ans[nr][nc]==-1){
                        ans[nr][nc]=ans[curr[0]][curr[1]]+1;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
        }

        return ans;
    }
}