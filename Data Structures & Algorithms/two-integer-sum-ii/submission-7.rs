impl Solution {
    pub fn two_sum(numbers: Vec<i32>, target: i32) -> Vec<i32> {
        let length = numbers.len();

        let mut index: Vec<i32> = Vec::with_capacity(2);
        index.resize(2,0);
        index[0] = 0;
        index[1] = length as i32 - 1;

        println!("{:?}", length);

        loop{

            let number_one = numbers[index[0] as usize];
            let number_two = numbers[index[1] as usize];
            let total = number_one + number_two;

            println!("{:?}", total);
            println!("{:?}", index);

            if total == target{
                index[0] += 1;
                index[1] += 1;
                return index;
            }
            if total > target{
                index[1] -= 1;
            }
            else if total < target{
                index[0] += 1;
            }
        }
        // return vec![0;2];
    }
}
