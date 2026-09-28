class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] cache = new int[nums.length];
        Arrays.fill(cache,-1);
        for(int i = 0; i < nums.length; i++){
           cache[i] = search(nums,i,cache);
        }
        int max = -1;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(cache[i],max);
        }

        // System.out.println(Arrays.toString(cache));
        return max;
    }

    private int search(int[] nums, int i, int[] cache){
        if(cache[i] != -1){
            return cache[i];
        }

        if(i == nums.length - 1){
            cache[i] = 1;
            return cache[i];
        }

        int max = 0;
        // System.out.println(i);
        for(int j = i+1; j < nums.length; j++){
            if(nums[j] > nums[i]){
                // System.out.println(i + " searching:" + j);
                max = Math.max(max,search(nums,j,cache));
            }
        }
        cache[i] = max + 1;
        // System.out.println(Arrays.toString(cache));
        return cache[i];
    }
}
