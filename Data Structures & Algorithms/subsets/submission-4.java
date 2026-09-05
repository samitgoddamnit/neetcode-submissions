class Solution {
    //didn't really implement a backtracking method. rather, used an iterative approach with a stack.
    //going to implement the backtracking method now.
    //finished ! used AI to solve issue regarding adding to res (needed to make clones)
    public List<List<Integer>> subsets(int[] nums) {
        return dfs(0,nums,new ArrayList(), new ArrayList());
    }

    private List<List<Integer>> dfs(int i, int[] nums, List<Integer> subset, List<List<Integer>> result){
        if(i == nums.length){
            //made a decision for each number in nums to include or ignore
            result.add(new ArrayList(subset));
            return result;
        }
        subset.add(nums[i]);
        i += 1;
        result = dfs(i,nums,subset,result);
        subset.remove(subset.size() - 1);
        return dfs(i,nums,subset,result);
    }

    
}
