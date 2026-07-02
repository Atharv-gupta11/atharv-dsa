class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean visited[]=new boolean[n];
        int cnt=0;
        for(int i=0;i<n;i++){
            if(visited[i]==false){
                dfs(isConnected,i,visited,n);
                cnt++;
            }
        }
        return cnt;
    }

    void dfs(int [][]isConnected,int currnode,boolean vis[],int n){
        if(vis[currnode]==true)return;

        vis[currnode]=true;

        for(int i=0;i<n;i++){
            if(isConnected[currnode][i]==1){
                if(vis[i]==false){
                    dfs(isConnected,i,vis,n);
                }
            }
        }
    }
}