class Solution {
    public int makeConnected(int n, int[][] connections) {
        int extra=0;
        int parent[]=new int[n];
        for(int i=0;i<n;i++)parent[i]=i;
        int rank[]=new int[n];

        for(int e[] : connections){
            int u=e[0];
            int v=e[1];

            if(find(u,parent)==find(v,parent)){
                extra++;
                continue;
            }
            union(u,v,rank,parent);
        }
        int cmp=0;
        for(int i=0;i<n;i++){
            if(i==parent[i]){
                cmp++;
            }
        }

        int req=cmp-1;
        if(extra>=req)return req;
        return -1;

    }

    int find(int a,int parent[]){
        if(a==parent[a])return a;
        
        return parent[a]=find(parent[a],parent); 
    }

    void union(int a,int b,int rank[],int parent[]){
        int pa=find(a,parent);
        int pb=find(b,parent);

        if(pa==pb)return;
        
        if(rank[pa]==rank[pb]){
            parent[pb]=pa;
            rank[pa]++;
        }
        else{
            if(rank[pa]>rank[pb]){
                parent[pb]=pa;
            }
            else{
                parent[pa]=pb;
            }
        }
    }
}