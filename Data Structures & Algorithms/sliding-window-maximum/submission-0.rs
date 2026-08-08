impl Solution {
    pub fn max_sliding_window(nums: Vec<i32>, k: i32) -> Vec<i32> {
        // gonna try a monotonic decreasing queue, kinda got the idea from the topics section in the problem...
        let mut queue : Vec<i32> = Vec::new();
        let mut res: Vec<i32> = Vec::new();
        let mut l = 0;
        for r in 0..nums.len(){
            if r as i32 - l as i32 + 1 > k{
                if queue[0] == nums[l]{
                    queue.remove(0);
                }
                l += 1; 
            }

            while let Some(last) = queue.last(){
                if *last < nums[r]{
                    queue.pop();
                }
                else{
                    break;
                }
            }
            queue.push(nums[r]);
            if r as i32 >= k - 1{
                res.push(queue[0]);
            }
        }
        res
    }
}
