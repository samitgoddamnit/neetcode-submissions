class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> subset = new ArrayList();
        for(int i = 0; i < nums.length; i++){
            subset.add(nums[i]);
        }
        return dfs(nums,subset,new ArrayList(),new ArrayList());
    }

    private List<List<Integer>> dfs(int[] nums, List<Integer> subset,List<Integer> permutation,List<List<Integer>> result){
        if(permutation.size() == nums.length){
            result.add(new ArrayList(permutation));
            return result;
        }
        int length = subset.size();
        for(int i = 0; i < length; i++){
            int tmp = subset.get(i);
            permutation.add(tmp);
            subset.remove(i);
            result = dfs(nums,subset,permutation,result);
            permutation.remove(permutation.size() - 1);
            subset.add(i,tmp);
        }
        return result;
    }
}
