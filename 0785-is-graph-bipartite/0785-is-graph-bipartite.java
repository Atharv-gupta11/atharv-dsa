class Solution {
    public boolean isBipartite(int[][] graph) {
        int color[]=new int[graph.length];
        for(int i=0;i<color.length;i++)color[i]=-1;

        for(int i=0;i<color.length;i++){
            if(color[i]==-1){
                if(!dfs(graph,i,color,0))return false;
            }
        }
        return true;
    }

    boolean dfs(int [][] graph,int curr, int color[],int clr){
        if(color[curr]!=-1)return true;

        color[curr]=clr;

        for(int neighbor : graph[curr]){
            if(color[neighbor]==-1){
                if(!dfs(graph,neighbor,color,1-clr))return false;
            }
            else{
                if(color[neighbor]==color[curr])return false;
            }
        }
        return true;

    }
}