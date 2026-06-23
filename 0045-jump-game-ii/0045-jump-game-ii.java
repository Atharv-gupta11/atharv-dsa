class Solution {
    public int jump(int[] nums) {
        int mr=0;
        int idx=-1;
        int ans=0;
        int i=0;
        while(i<nums.length-1){
            for(int j=1;j<=nums[i];j++){
                int ridx=i+j;
                if(ridx>=nums.length-1)return ans+1;
                if(nums[ridx]+ridx>=mr){
                    mr=nums[ridx]+ridx;
                    idx=ridx;
                }
            }
            i=idx;
            ans++;
        }
        return ans;
    }
}