class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int n=wordList.size();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int targetidx=-1;

        for(int i=0;i<n;i++){
            if(wordList.get(i).equals(endWord))targetidx=i;
            for(int j=i+1;j<n;j++){
                if(i==j)continue;
                if(differbyone(wordList.get(i),wordList.get(j))){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        if(targetidx==-1)return 0;

        System.out.println(adj);
        System.out.println(targetidx);
        int ans=Integer.MAX_VALUE;
        boolean visited[]=new boolean[n];

        for(int i=0;i<n;i++){
            if(differbyone(beginWord,wordList.get(i))){
                System.out.println(i);
                //can be start
                int t=bfs(n,adj,i,targetidx);
                ans=Math.min(ans,t);
            }
        }
        if(ans==2147483647)return 0;
        return ans;
    }

    int bfs(int V,ArrayList<ArrayList<Integer>> adj,int curr,int target){
        boolean visited[]=new boolean[V];
        Queue<Integer> q=new LinkedList<>();
        q.add(curr);
        visited[curr]=true;
        int d=1;

        while(!q.isEmpty()){
            int sz=q.size();

            for(int i=0;i<sz;i++){
                int node=q.remove();
                if(node==target)return d+1;

                for(int neighbor : adj.get(node)){
                    if(visited[neighbor]==false){
                        q.add(neighbor);
                        visited[neighbor]=true;
                    }
                }
            }
            d++;
        }
        return Integer.MAX_VALUE;
    }


    boolean differbyone(String s1,String s2){
        if(s1.length()!=s2.length())return false;
        int diff=0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                diff++;
                if(diff>1){
                    return false;
                }
            }
        }
        return true;
    }
}