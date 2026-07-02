class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }   
        int indegree[]=new int[numCourses];

        for(int e[]:prerequisites){
            int u=e[0];
            int v=e[1];
            adj.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> q=new LinkedList<>();
        
        int pnodes=0;

        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int curr=q.remove();
            pnodes++;

            for(int n: adj.get(curr)){
                indegree[n]--;
                if(indegree[n]==0){
                    q.add(n);
                }
            }
        }

        return pnodes==numCourses;
    }
}