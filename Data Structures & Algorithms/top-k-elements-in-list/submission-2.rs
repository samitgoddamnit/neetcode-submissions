impl Solution {
    pub fn top_k_frequent(nums: Vec<i32>, k: i32) -> Vec<i32> {
        let mut tally: HashMap<i32,i32> = HashMap::new();
        for num in nums{
            tally.entry(num).and_modify( |e| { *e += 1 } ).or_insert(1);
        }
        let mut tally_vec: Vec<_> = tally.iter().collect();
        tally_vec.sort_by(|a,b| b.1.cmp(&a.1));
        let slice = &tally_vec[..k as usize];
        let mut result: Vec<i32> = Vec::new();
        for elem in slice{
            result.push(*elem.0);
        }
        result
        // let dummy: Vec<_> = Vec::new();
        // dummy
    }
}
