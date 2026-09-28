class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if(sum % 2 != 0){
            return false;
        }
        int target = sum / 2;
        Boolean[][] cache = new Boolean[nums.length+1][target+1];
        return dfs(nums,0,0,target,cache);
    }

    private boolean dfs (int[] nums, int i,int total,int target,Boolean[][] cache){
        if(i == nums.length){
            if(total == target){
                cache[i][total] = true;
                return cache[i][total];
            }
            cache[i][total] = false;
            return false;
        }

        if(cache[i][total] != null){
            return cache[i][total];
        }

        boolean tmp = false;
        if(total + nums[i] <= target){
            tmp = dfs(nums,i+1,total + nums[i],target,cache);
        }
        if(tmp){
            cache[i][total] = true;
            return cache[i][total];
        }
        tmp = dfs(nums,i+1,total,target,cache);
        if(tmp){
            cache[i][total] = true;
            return cache[i][total];
        }
        cache[i][total] = false;
        return cache[i][total];
    }
}
