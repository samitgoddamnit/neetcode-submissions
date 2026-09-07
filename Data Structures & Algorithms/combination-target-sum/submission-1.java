class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        return dfs(nums,target,0,new ArrayList(),new ArrayList(),0);
    }

    private List<List<Integer>> dfs (int[] nums, int target, int i, List<List<Integer>> result, List<Integer> subset, int sum){
        if(sum == target){
            result.add(new ArrayList(subset));
            return result;
        }
        else if(i == nums.length || sum > target){
            return result;
        }
        else{
            subset.add(nums[i]);
            result = dfs(nums,target,i,result,subset,sum + nums[i]);
            subset.remove(subset.size() - 1);
            return dfs(nums,target,i+1,result,subset,sum);
        }
    }

}
