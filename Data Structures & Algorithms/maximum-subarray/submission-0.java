class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int total = 0;
        for(int i = 0; i < nums.length; i++){
            total = Math.max(total + nums[i],nums[i]);
            max = Math.max(total,max);
        }
        return max;
    }
}
