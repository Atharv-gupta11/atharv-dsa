class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
         ArrayList<int []> ans=new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int s=intervals[0][0];
        int e=intervals[0][1];
     
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<e){
                e=Math.min(intervals[i][1],e);
            }
            else{
                ans.add(new int[]{s,e});
                s=intervals[i][0];
                e=intervals[i][1];
            }
        }
        ans.add(new int[]{s,e});
        System.out.println(ans.size());
        return intervals.length-ans.size();
    }
}