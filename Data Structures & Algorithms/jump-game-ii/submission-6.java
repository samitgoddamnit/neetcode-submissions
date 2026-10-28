class Solution {
    public int jump(int[] nums) {
        int numberOfJumps = 0;
        int currentMax = 0;
        int nextMax = 0;

        if(nums.length == 1){
            return 0;
        }

        for(int i = 0; i < nums.length; i++){
            int jumpDistance = nums[i];
            nextMax = Math.max(i + jumpDistance,nextMax);
            if(i == currentMax){
                numberOfJumps += 1;
                currentMax = nextMax;
                if(nextMax >= nums.length - 1){
                    return numberOfJumps;
                }
            }
        }
        return numberOfJumps;
    }
}
