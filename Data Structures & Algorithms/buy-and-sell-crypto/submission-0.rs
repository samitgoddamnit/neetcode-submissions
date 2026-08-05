impl Solution {
    pub fn max_profit(prices: Vec<i32>) -> i32 {
        let mut min: i32 = prices[0];
        let mut max_profit: i32 = 0;

        for i in 1..prices.len(){
            if prices[i] < min{
                min = prices[i];
            }
            let profit = prices[i] - min;
            println!("profit: {}, min: {}",profit,min);
            if profit > max_profit{
                max_profit = profit;
            }
        }
        max_profit
    }
}
