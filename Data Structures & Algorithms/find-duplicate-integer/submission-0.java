class Solution {
    public int findDuplicate(int[] nums) {
        //looked at hint one.
        //was not able to do this within one hour...
        //neetcode did complain about it for what it's worth though lmfao

        //today I'll write the implementation, but you should definitely retry this at some point.
        int slow = 0;
        int fast = 0;
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);
        int slow2 = 0;
        while (slow2 != slow){
            slow2 = nums[slow2];
            slow = nums[slow];
        }
        return slow;
    }
}
