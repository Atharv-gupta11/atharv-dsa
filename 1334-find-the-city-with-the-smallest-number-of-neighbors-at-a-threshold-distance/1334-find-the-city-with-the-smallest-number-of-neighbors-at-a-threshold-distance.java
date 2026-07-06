class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int dist[][]=new int [n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j)dist[i][j]=0;
                else dist[i][j] = (int)1e9;
            }
        }

        for(int[] e : edges){
            int u = e[0], v = e[1], w = e[2];
            dist[u][v] = w;
            dist[v][u] = w;
        }

        for(int via = 0; via < n; via++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(dist[i][via] != 1e9 && dist[via][j] != 1e9){
                        dist[i][j] = Math.min(dist[i][j],
                                              dist[i][via] + dist[via][j]);
                    }
                }
            }
        }

        int min=Integer.MAX_VALUE;
        int ans=-1;
        for(int i=0;i<n;i++){
            int cnt=0;
            for(int j=0;j<n;j++){
                if(i==j)continue;
                if(dist[i][j]<=distanceThreshold)cnt++;
            }
            if(cnt<=min){
                ans=i;
                min=cnt;
            }
        }

        return ans;

    }
}