impl Solution {
    pub fn find_min(nums: Vec<i32>) -> i32 {

        let mut l: usize = 0;
        let mut r: usize = nums.len() - 1;

        while l <= r{
            let m = l + (r - l) / 2;

            let m_val = nums[m];
            let l_val = nums[l];
            let r_val = nums[r];

            if l_val <= m_val && m_val <= r_val{
                return l_val;
            }
            else if l_val <= m_val &&  m_val >= r_val{
                l = m + 1
            }  
            else if l_val >= m_val && m_val <= r_val{
                r = m;
            }
        }
        -1
    }
}
