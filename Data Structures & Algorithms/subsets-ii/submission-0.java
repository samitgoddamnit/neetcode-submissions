class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        return dfs(nums,0,new ArrayList(),new ArrayList());
    }

    private List<List<Integer>> dfs(int[] nums,int i,List<Integer> subset,List<List<Integer>> result){
        if(i == nums.length){
            result.add(new ArrayList(subset));
            return result;
        }
        subset.add(nums[i]);
        result = dfs(nums,i+1,subset,result);
        subset.remove(subset.size() - 1);
        while(i+1 < nums.length && nums[i] == nums[i + 1]){
            i += 1;
        }
        return dfs(nums,i+1,subset,result);
    }
}
