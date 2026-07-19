impl Solution {
    pub fn three_sum(nums: Vec<i32>) -> Vec<Vec<i32>> {
        let last = nums.len() - 1;
        let mut result: Vec<Vec<i32>> = Vec::new();
        let mut srtd_nums = nums;
        srtd_nums.sort();
        println!("{:?}", srtd_nums);
        for i in 0..last{
            let target = -srtd_nums[i];
            let mut l: usize = 0;
            let mut r: usize = last;
            let mut skip: Vec<usize> = Vec::new();
            skip.push(i);
            while l < r {
                let total = srtd_nums[l] + srtd_nums[r];
                if total > target || skip.contains(&r){
                    r -= 1;
                }
                else if total < target || skip.contains(&l){ 
                    l += 1;
                }
                else if total == target{
                    let mut res: Vec<i32> = Vec::new();
                    res.push(-target as i32);
                    res.push(srtd_nums[l] as i32);
                    res.push(srtd_nums[r] as i32);
                    res.sort();
                    if !result.contains(&res){
                        result.push(res);
                    }
                    else{
                        skip.push(l);
                        skip.push(r);
                    }
                }
            }
        }
        return result;
    }
}
