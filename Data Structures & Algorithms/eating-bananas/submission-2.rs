pub fn hours(array: &Vec<i32>, k: i64) -> i64{
    let mut total: i64 = 0;
    for i in 0..array.len(){
        total += (array[i] as i64 / k) + (array[i] as i64 % k != 0) as i64;
    }
    total 
}
impl Solution {
    pub fn min_eating_speed(piles: Vec<i32>, h: i32) -> i32 {
        let mut range_min: i64 = 1;
        let mut range_max: i64 = *piles.iter().max().unwrap() as i64;
        let mut result: i64 = 0;

        let mut l: i64 = range_min;
        let mut r: i64 = range_max;

        while l < r {
            let mid = l + (r - l) / 2;
            // println!("{:?}",r);
            let value = hours(&piles,mid);
            println!("hours taken is {:?} and the rate tested was {:?}",value,mid);
            if value <= h.into(){
                r = mid;
            }
            else if value > h.into(){
                l = mid + 1;
            }
        }
        result = l;

        println!("{:?}",result);
        // println!("{:?}",hours(&piles,5));
        result as i32
    }

}
