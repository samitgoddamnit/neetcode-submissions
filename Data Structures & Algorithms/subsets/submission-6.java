class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return dfs(nums,0,new ArrayList(), new ArrayList());
    }

    private List<List<Integer>> dfs(int[] nums, int i, List<List<Integer>> result, List<Integer> subset){
        if(i == nums.length){
            result.add(new ArrayList(subset));
            return result;
        }
        subset.add(nums[i]);
        result = dfs(nums,i+1,result,subset);
        subset.remove(subset.size()-1);
        return dfs(nums,i+1,result,subset);
    }

}
