class Solution {
    //was not able to do this one either.... backtracking is fucking hard man
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return dfs(0,candidates,target,0,new ArrayList(), new ArrayList());
    }

    private List<List<Integer>> dfs(int i, int[] candidates, int target, int total, List<Integer> subset, List<List<Integer>> result){
        // System.out.println(subset);
        // System.out.println(i);
        // System.out.println(candidates[i]);
        if(total == target){
            // System.out.println("found target");
            result.add(new ArrayList(subset));
            return result;
        }
        else if(i == candidates.length || total > target){
            // System.out.println("out of numbers");
            return result;
        }
        else{
            subset.add(candidates[i]);
            result = dfs(i+1,candidates,target,total+candidates[i],subset,result);
            //now explore next non-duplicate value
            subset.remove(subset.size() - 1);
            // System.out.println(subset);
        
            while(i + 1 < candidates.length && candidates[i] == candidates[i+1]){
                i += 1;
            }
            result = dfs(i+1,candidates,target,total,subset,result);
            return result;
        }
    }
}
