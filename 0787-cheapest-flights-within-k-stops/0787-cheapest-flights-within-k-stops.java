class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int res[]=new int[n];
        for(int i=0;i<n;i++)res[i]=Integer.MAX_VALUE;
        res[src]=0;


        ArrayList<ArrayList<int []>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());

        for(int f[]:flights){
            int u=f[0];
            int v=f[1];
            int w=f[2];

            adj.get(u).add(new int[]{v,w});
        }

        int lvl=0;

        Queue<int []> q=new LinkedList<>();
        q.add(new int[]{src,0});

        while(!q.isEmpty() && lvl<=k){
            int sz=q.size();

            for(int i=0;i<sz;i++){
                int arr[]=q.remove();
                int curr=arr[0];
                int d=arr[1];

                for(int a[]: adj.get(curr)){
                    int v=a[0];
                    int nd=a[1]+d;

                    if(nd<res[v]){
                        res[v]=nd;
                        q.add(new int[]{v,nd});
                    }
                }
            }
            lvl++;
        }

        if(res[dst]==Integer.MAX_VALUE)return -1;
        return res[dst];
    }
    
}