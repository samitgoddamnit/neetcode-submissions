impl Solution {
    pub fn search(nums: Vec<i32>, target: i32) -> i32 {
        let mut l: i32 = 0;
        let mut r: i32 = nums.len() as i32 - 1;

        while l <= r {
            let m: i32 = l + (r - l) / 2;
            println!("l:{}, m:{}, r:{}",l,m,r);
            let value_m = nums[m as usize];
            let value_l = nums[l as usize];
            let value_r = nums[r as usize];

            if value_m == target{
                return m as i32;
            }
            else if value_l <= value_r{
                println!("fully ordered, use normal binary search");
                //only working in ordered half
                if target < value_m{
                    r = m - 1;
                }
                else{
                    l = m + 1;
                }
            }
            else if value_m <= value_l{
                // right half is ordered
                println!("ordered right half");
                let mr_value = nums[(m + 1) as usize];
                if mr_value <= target && target <= value_r{
                    l = m + 1;
                }
                else{
                    r = m - 1;
                }

            }
            else if value_r <= value_m{
                // left half is ordered
                println!("ordered left half");
                if value_l <= target && target <= value_m{
                    r = m - 1;
                }
                else{
                    l = m + 1;
                }
            }
        }
        -1
    }
}
