impl Solution {
    pub fn search(nums: Vec<i32>, target: i32) -> i32 {
        let mut right: usize = nums.len();
        let mut left: usize = 0;
        let mut mid: usize;

        while left < right{
            mid = left + (right - left) / 2;
            let value = nums[mid];
            if value == target{
                return mid as i32;
            }
            else if value > target{
                right = mid;
            }
            else if value < target{
                left = mid + 1;
            }
        } 
        return -1;
    }
}
