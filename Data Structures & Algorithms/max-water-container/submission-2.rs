impl Solution {
    pub fn max_area(heights: Vec<i32>) -> i32 {
        let length = heights.len();
        let mut max = 0;
        let mut l = 0;
        let mut r = length - 1;

        loop{
            
            let left_height = *heights.get(l).unwrap();
            let right_height = *heights.get(r).unwrap();

          
            println!("({:?},{:?})",left_height,right_height);

            let mut area: i32 = 0;

            if left_height > right_height{
                area = right_height * (r - l) as i32;
            }
            else{
                area = left_height * (r - l) as i32;
            }

            if area > max{
                max = area;
            }

            if left_height > right_height{
                r -= 1;
            }
            else if left_height < right_height {
                l += 1;
            }
            else{
                r -= 1;
                l += 1;
            }

            if r <= l{
                break;
            }
           
        }
        return max;
    }
}
