impl Solution {
    pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
        let mut map: HashMap<i32,Vec<i32>> = HashMap::new();
        for (index,elem) in nums.iter().enumerate(){
            let mut t = target - elem;
            if map.contains_key(&t){
                let help = map.get(&t).unwrap();
                println!("{:?}",help);
                println!("{}",help[0]);
                let mut ans: Vec<i32> = Vec::new();
                ans.push(help[0] as i32);
                ans.push(index as i32);
                return ans;
            }
            else{
                // add to memory of current keys we're looking for
                map.entry(*elem).or_insert(Vec::<i32>::new()).push(index as i32);
            }
        }
        nums
    }
}
