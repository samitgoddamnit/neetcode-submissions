class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return dfs(candidates, target, 0, 0, new ArrayList(), new ArrayList());
    }

    private List<List<Integer>> dfs(int[] candidates, int target, int i, int total, List<Integer> subset, List<List<Integer>> result){
        if(total == target){
            result.add(new ArrayList(subset));
            return result;
        }
        else if(i == candidates.length || total > target || total + candidates[i] > target){
            return result;
        }
        else{
            subset.add(candidates[i]);
            result = dfs(candidates,target,i+1,total + candidates[i],subset,result);
            subset.remove(subset.size() - 1);
            while (i+1 < candidates.length && candidates[i] == candidates[i+1]){
                i += 1;       
            }
            return dfs(candidates,target,i+1,total,subset,result);
        }
    }
}
