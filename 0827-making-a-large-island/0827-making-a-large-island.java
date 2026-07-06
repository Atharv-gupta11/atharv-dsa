class Solution {
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        int parent[][][]=new int[n][n][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                parent[i][j]=new int[]{i,j};
            }
        }
        int size[][]=new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1)size[i][j]=1;
            }
        }
        int directions[][]={{-1,0},{0,-1},{1,0},{0,1}};

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    
                    for(int dir[]:directions){
                        int nr=i+dir[0];
                        int nc=j+dir[1];

                        if(nr>=0 && nr<n && nc>=0 && nc<n){
                            if(grid[nr][nc]==1){
                                union(i,j,nr,nc,size,parent);
                            }
                        }
                    }
                }
            }
        }
           int max=0;
           
        for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
            int[] par = find(i, j, parent);
            max = Math.max(max, size[par[0]][par[1]]);
        }
    }
}
     

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    int sum=1;
                    HashSet<String> set=new HashSet<>();
                    for(int dir[]:directions){
                        int nr=i+dir[0];
                        int nc=j+dir[1];
                        if(nr>=0 && nr<n && nc>=0 && nc<n){
                            int par[]=find(nr,nc,parent);
                            int sz=size[par[0]][par[1]];
                            String key=par[0]+","+par[1];
                            if(set.contains(key))continue;
                            sum+=sz;  
                            set.add(key);      
                        }
                    }
                    max=Math.max(sum,max);
                }
            }
        }
        return max;
    }

    int[]  find(int r,int c,int parent[][][]){
        int arr[]=parent[r][c];
        int pr=arr[0];
        int pc=arr[1];
        if(pr==r && pc==c)return parent[r][c];

        return parent[r][c]=find(pr,pc,parent);
    }

    void union(int r1,int c1,int r2,int c2, int size[][],int parent[][][]){
        int p1[]=find(r1,c1,parent);

        int p2[]=find(r2,c2,parent);

        if(p1==p2)return;

        int p1r=p1[0];
        int p1c=p1[1];
        int p2r=p2[0];
        int p2c=p2[1];

        if(size[p1r][p1c]==size[p2r][p2c]){
            parent[p1r][p1c][0] = p2r;
            parent[p1r][p1c][1] = p2c;
            size[p2r][p2c] += size[p1r][p1c];
        }
        else{
            if(size[p2r][p2c]>size[p1r][p1c]){
                parent[p1r][p1c][0] = p2r;
                parent[p1r][p1c][1] = p2c;
                size[p2r][p2c] += size[p1r][p1c];
            }
            else{
                parent[p2r][p2c][0] = p1r;
                parent[p2r][p2c][1] = p1c;
                size[p1r][p1c] += size[p2r][p2c];
            }
        }

    }
}