impl Solution {
    pub fn product_except_self(nums: Vec<i32>) -> Vec<i32> {
        let mut zero_indexes: Vec<usize> = Vec::<usize>::new();
        let mut total: i32 = 1;
        let capacity = nums.len();
        for (index,num) in nums.iter().enumerate(){
            if *num == 0{
                zero_indexes.push(index);
            }
            else{
                total = total * num;
            }
        }

        if zero_indexes.len() > 1{
            return vec![0;capacity];
        }

        if zero_indexes.len() == 1{
            let mut results = vec![0;capacity];
            results[zero_indexes[0]] = total;
            return results;
        }
        
        let mut prefix = vec![1;capacity];
        let mut suffix = vec![1;capacity];
        let end = capacity - 1;
        prefix[0] = nums[0];
        suffix[end] = nums[end];

        for (index,num) in nums.iter().enumerate(){
            if !(index == 0) {
                prefix[index] = num * prefix[index - 1];
            }
        }

        // println!("{:?}",suffix);
        for (index,num) in nums.iter().rev().enumerate(){
            if !(index == 0){
                // println!("{:?} multiplied by {}",num,suffix[capacity - index]);
                // println!("index is {}",index);
                suffix[capacity - index - 1] = num * suffix[capacity - index];
            }
        }

        // println!("{:?}",prefix);
        // println!("{:?}",suffix);
        let mut products: Vec<i32> = Vec::<i32>::with_capacity(capacity);
        products.resize(capacity,1);

        products[0] = suffix[1];
        products[end] = prefix[end-1];

        for (index,num) in products.iter_mut().enumerate(){
            if !(index == 0 || index == end){
                // println!("{:?}",prefix[index - 1] * suffix[index + 1]);
                *num = prefix[index - 1] * suffix[index + 1];
            }
        }
        products
    }
}
