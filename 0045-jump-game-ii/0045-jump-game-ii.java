class Solution {
    public int jump(int[] nums) {
        if(nums.length==1)return 0;
        int coverage=0;
        int lastJumpIdx=0;
        int jumps=0;
        for(int i=0;i<nums.length;i++){
            coverage=Math.max(coverage,i+nums[i]);

            if(i==lastJumpIdx){
                lastJumpIdx=coverage;
                jumps++;

                if(coverage>=nums.length-1){
                    return jumps;
                }
            }
        }
        return jumps;
    }
}