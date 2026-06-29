impl Solution {
    pub fn has_duplicate(nums: Vec<i32>) -> bool {
        let mut values = HashSet::<i32>::new();
        for x in nums.iter(){
            if values.contains(x){
                return true;
            }
            else{
                values.insert(*x);
            }
        }
        return false;
    }
}

