impl Solution {
    pub fn longest_consecutive(nums: Vec<i32>) -> i32 {
        let mut number_set: HashSet<i32> = HashSet::new();
        let mut largest_chain: i32 = 0;
        for num in nums.iter(){
            number_set.insert(*num);
        }

        let mut start_points: Vec<i32> = Vec::new();
        for num in nums.iter(){
            if !number_set.contains(&(*num - 1)){
               start_points.push(*num);
            }
        }

        for start in start_points.iter(){
            let mut count: i32 = 1;
            let mut next: i32 = *start + 1;  
            while number_set.contains(&next) {
                count += 1;
                next += 1;
            }
            if count > largest_chain{
                largest_chain = count;
            }

        }
        return largest_chain;
    }
}
