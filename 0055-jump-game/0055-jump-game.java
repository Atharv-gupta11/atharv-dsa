class Solution {
    public boolean canJump(int[] nums) {
        int mr=0;

        for(int i=0;i<nums.length;i++){
            int x=nums[i];
            if(i>mr)return false;
            mr=Math.max(mr,i+x);
        }
        return true;

    }
}