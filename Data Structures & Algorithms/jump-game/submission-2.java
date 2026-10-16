class Solution {
    public boolean canJump(int[] nums) {
        return dp(nums,0,new Boolean[nums.length]);
    }

    private boolean dp(int[] nums, int i, Boolean[] cache){
        if(i >= nums.length){
            return false;
        }
        if(cache[i] != null){
            return cache[i];
        }
        
        if(i == nums.length - 1){
            cache[i] = true;
            return cache[i];
        }

        if(nums[i] == 0){
            cache[i] = false;
            return cache[i];
        }

        cache[i] = false;
        for(int j = 1; j <= nums[i]; j++){
            cache[i] = cache[i] || dp(nums,i+j,cache);
        }
        return cache[i];
    }
}
