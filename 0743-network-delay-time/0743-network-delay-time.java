class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int ans[]=new int [n+1];

        ArrayList<ArrayList<int []>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int arr[]:times){
            int u=arr[0];
            int v=arr[1];
            int w=arr[2];

            adj.get(u).add(new int[]{v,w});
        }

        for(int i=0;i<=n;i++)ans[i]=Integer.MAX_VALUE;


        ans[k]=0;

        PriorityQueue<Info> pq=new PriorityQueue<>();
        pq.add(new Info(k,0));

        while(!pq.isEmpty()){
            Info i=pq.remove();
            int curr=i.node;
            int d=i.dist;

            for(int arr[] : adj.get(curr)){
                int v=arr[0];
                int w=arr[1];

                int nd=w+d;
                if(nd<ans[v]){
                    ans[v]=nd;
                    pq.add(new Info(v,nd));
                }
            }
        }

        int res=-1;

        for(int i=1;i<=n;i++){
            int x=ans[i];
            res=Math.max(res,x);
        }
        if(res==Integer.MAX_VALUE) return -1;
        return res;

    }

    class Info implements Comparable <Info> {
        int node;
        int dist;

        public Info(int n,int d){
            node=n;
            dist=d;
        }

        @Override 
        public int compareTo(Info i){
            return this.dist-i.dist;
        }
    }
}