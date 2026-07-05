class Solution {
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<int []>> adj=new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int arr[]:roads){
            int u=arr[0];
            int v=arr[1];
            int w=arr[2];

            adj.get(u).add(new int[]{v,w});
            adj.get(v).add(new int[]{u,w});
        }

        PriorityQueue<Info> pq=new PriorityQueue<>();
        pq.add(new Info(0,0));
        long mod=1000000007L;
        long res[]=new long[n];
        int ways[]=new int[n];
        Arrays.fill(res, Long.MAX_VALUE);
res[0] = 0;
        ways[0]=1;

        while(!pq.isEmpty()){
            Info i=pq.remove();
            int curr=i.n;
            long dist=i.d;


            for(int arr[] : adj.get(curr)){
                int v=arr[0];
                int w=arr[1];

                long nd=w+dist;

                if(nd<res[v]){
                    res[v]=nd;
                    ways[v]=ways[curr];
                    pq.add(new Info(v,nd));
                }
                else if(nd==res[v]){
                    ways[v]=(int)((ways[curr]+ways[v])%mod);
                }
            }
        }
        return ways[n-1];
    }

    public class Info implements Comparable<Info>{
        long d;
        int n;

        public Info(int n,long d){
            this.d=d;
            this.n=n;
        }

        @Override 
        public int compareTo(Info i2){
           return Long.compare(this.d, i2.d);
        }
    }
}