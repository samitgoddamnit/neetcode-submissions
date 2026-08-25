class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        Stack<Integer> increasing = new Stack();
        Stack<Integer> decreasing = new Stack();

        int length = 0;

        for(int i = 0; i < nums.length; i++){
            if(increasing.empty()){
                increasing.push(nums[i]);
            }
            else{
                while(!increasing.empty() && increasing.peek() >= nums[i]){
                    increasing = new Stack();
                }
                increasing.push(nums[i]);
            }

            length = Math.max(increasing.size(),length);

            if(decreasing.empty()){
                decreasing.push(nums[i]);
            }
            else{
                while(!decreasing.empty() && decreasing.peek() <= nums[i]){
                    decreasing = new Stack();
                }
                decreasing.push(nums[i]);
            }

            length = Math.max(decreasing.size(),length);
            System.out.println(decreasing);
            System.out.println(increasing);
        }
        return length;
    }
}