class Solution {
    public int maxProduct(int[] nums) {
        // could not solve this, required study of a new algorithm (Kadane's algorithm)
        int[] result = new int[nums.length];

        int l_max = 0;
        int l_min = 0;
        int global_max = 0;
        for(int i = 0; i < result.length; i++){
            if(i == 0){
                l_min = nums[i];
                l_max = nums[i];
                global_max = Math.max(l_max,l_min);
                continue;
            }

            int min_tmp = l_min * nums[i];
            int max_tmp = l_max * nums[i];

            l_max = Math.max(nums[i],Math.max(min_tmp,max_tmp));
            l_min = Math.min(nums[i],Math.min(min_tmp,max_tmp));

            // System.out.println(l_max);
            // System.out.println(l_min);
            global_max = Math.max(global_max,Math.max(l_max,l_min));
        }

        return global_max;
    }
}
