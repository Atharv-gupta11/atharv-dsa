class Solution {
    public int minimumEffortPath(int[][] heights) {
        int ans=-1;
        int m=heights.length;
        int n=heights[0].length;

        PriorityQueue<Info> pq=new PriorityQueue<>();
        pq.add(new Info(0,0,0));

        int directions[][]={{-1,0},{0,-1},{1,0},{0,1}};
        int res[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                res[i][j]=Integer.MAX_VALUE;
            }
        }
        res[0][0]=0;

        while(!pq.isEmpty()){
            Info i=pq.remove();
            int x=i.row;
            int y=i.col;
            int max_diff=i.maxdiff;

            for(int dir[]:directions){
                int nx=dir[0]+x;
                int ny=dir[1]+y;

                if(nx>=0 && nx<m && ny>=0 && ny<n){
                    int nd = Math.abs(heights[x][y] - heights[nx][ny]);
                    int newEffort = Math.max(max_diff, nd);

if(newEffort < res[nx][ny]){
    res[nx][ny] = newEffort;
    pq.add(new Info(nx, ny, newEffort));
}
                    
                }
            }
        }
        return res[m-1][n-1];
    }


    class Info implements Comparable<Info>{
        int row;
        int col;
        int maxdiff;

        public Info(int row,int col,int md){
            this.row=row;
            this.col=col;
            this.maxdiff=md;
        }

        @Override
        public int compareTo(Info i2){
            return this.maxdiff-i2.maxdiff;
        }
    } 
}