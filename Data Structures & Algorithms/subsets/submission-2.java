class Solution {
    //didn't really implement a backtracking method. rather, used an iterative approach with a stack.
    //going to implement the backtracking method now.
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        return dfs(0,nums,new ArrayList(),res);
    }

    private List<List<Integer>> dfs(int i, int[] nums, List<Integer> subset, List<List<Integer>> res){
        if(i == nums.length){
            res.add(new ArrayList<>(subset));
            return res;
        }
        subset.add(nums[i]);
        i += 1;
        res = dfs(i,nums,subset,res);
        subset.remove(subset.size() - 1);
        res = dfs(i,nums,subset,res);
        return res;
    }
    
}
