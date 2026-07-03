class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1)return -1;
        int n=grid.length;
        PriorityQueue<Info> pq=new PriorityQueue<>();
        pq.add(new Info(0,0,0));
        grid[0][0]=1;

        int directions[][]={{1,1},{1,0},{0,1},{-1,0},{0,-1},{-1,-1},{-1,1},{1,-1}};

        while(!pq.isEmpty()){
            Info i=pq.remove();
            int r=i.x;
            int c=i.y;
            int dist=i.d;

            if(r==n-1 && c==n-1)return dist+1;
            for(int dir[]:directions){
                int nr=r+dir[0];
                int nc=c+dir[1];

                if(nr>=0 && nr<n && nc>=0 && nc<n){
                    if(grid[nr][nc]==0){
                        grid[nr][nc]=1;
                        pq.add(new Info(nr,nc,dist+1));
                    }
                }
            }
        }
        return -1;
    }

    class Info implements Comparable<Info>{
        int x;
        int y;
        int d;

        public Info(int i,int j,int k){
            x=i;
            y=j;
            d=k;
        }

        @Override 
        public int compareTo(Info i2){
            return this.d-i2.d;
        }
    }
}