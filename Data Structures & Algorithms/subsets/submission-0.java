class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Stack<HashSet<Integer>> stack = new Stack();
        HashSet<HashSet<Integer>> set = new HashSet();
        List<List<Integer>> to_return = new ArrayList();
        stack.push(new HashSet());
        while(!stack.empty()){
            HashSet<Integer> sublist = stack.pop();
            if(!set.contains(sublist)){
                ArrayList<Integer> arr = new ArrayList<>(sublist);
                to_return.add(arr);
                set.add(sublist);
                for(int i = 0; i < nums.length; i++){
                    HashSet<Integer> subset = new HashSet(sublist);
                    subset.add(nums[i]);
                    stack.push(subset);
                }
            }
        }
        return to_return;




    }
}
