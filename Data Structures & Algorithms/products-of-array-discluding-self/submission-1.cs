public class Solution {
    public int[] ProductExceptSelf(int[] nums) {
        int total = 1;
        int[] ans = new int[nums.Length];
        int zeroCount = 0;
        for(int i=0;i<nums.Length;i++){
            if(nums[i] == 0){
                zeroCount++;
            }
            else{
                total =  total * nums[i];
            }
        }
        for(int i=0;i<nums.Length;i++){
            if(zeroCount > 1){
                ans[i] = 0;
            }
            else if(zeroCount == 1){
                if(nums[i] == 0){
                    ans[i] = total;
                }
                else{
                    ans[i] = 0;
                }
            }
            else{
                ans[i] = total / nums[i];
            }
        }
        return ans;
    }
}
