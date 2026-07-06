class Solution {
    public int removeStones(int[][] stones) {
        int rmv=0;
        int n=stones.length;
        int parent[]=new int[n];
        for(int i=0;i<n;i++)parent[i]=i;
        int rank[]=new int[n];
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(find(i,parent)==find(j,parent)){
                    continue;
                }

                if(stones[i][0]==stones[j][0] || stones[i][1]==stones[j][1]){
                    union(i,j,rank,parent);
                    rmv++;
                }
            }
        }
        return rmv;
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