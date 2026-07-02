class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        boolean visited[]=new boolean[n];

        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int edg[]:edges){
            int u=edg[0];
            int v=edg[1];


            adj.get(u).add(v);
            adj.get(v).add(u);
        }


        int cnt=0;
        for(int i=0;i<n;i++){
            if(visited[i]==false){
                nodes=0;
                totaledges=0;
                dfs(n,adj,i,visited);
                if(nodes*(nodes-1)/2 == totaledges/2)cnt++;
            }
        }
        return cnt;

    }

    int nodes;
    int totaledges;

    void dfs(int n, ArrayList<ArrayList<Integer>> adj,int curr,boolean visited[]){
        if(visited[curr]==true)return ;
        visited[curr]=true;
        nodes++;
        totaledges+=adj.get(curr).size();

        for(int neighbor  : adj.get(curr)){
            if(visited[neighbor]==false){
                dfs(n,adj,neighbor,visited);
            }
        }
    }

    

}