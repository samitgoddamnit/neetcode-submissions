class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        return dfs(0,nums,target,0,new ArrayList(),new ArrayList());
    }

    private List<List<Integer>> dfs(int i, int[] nums, int target,int total,List<Integer> subset,List<List<Integer>> result){
        if(total == target){
            result.add(new ArrayList(subset));
            return result;
        }
        else if (total > target || i == nums.length){
            return result;
        }
        else{
            //try current number
            total += nums[i];
            subset.add(nums[i]);
            result = dfs(i,nums,target,total,subset,result);
            //now remove from total and then try that branch
            total -= nums[i];
            subset.remove(subset.size() - 1);
            i += 1;
            return dfs(i,nums,target,total,subset,result);
        }
    }
}
