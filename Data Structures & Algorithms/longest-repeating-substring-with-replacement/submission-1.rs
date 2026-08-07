impl Solution {
    pub fn character_replacement(s: String, k: i32) -> i32 {
        let s = s.as_bytes();
        let mut char_sums : HashMap<u8, i32> = HashMap::new();
        let mut l = 0;
        let mut res = 0;
        
        for r in 0..s.len(){
            // println!("l is: {} and r is: {}",l,r);
            char_sums.entry(s[r]).and_modify(|c| *c += 1).or_insert(1);
            while Self::check_validity(&char_sums,k){
                // println!("entered here");
                char_sums.entry(s[l]).and_modify(|c| *c -= 1);
                if *char_sums.get(&s[l]).unwrap() == 0{
                    char_sums.remove(&s[l]);
                }
                l += 1;
            }
            
            res = res.max(r - l + 1);
            // println!("writing res as {}", res);
        }
        res as i32
    }

    fn check_validity(map: &HashMap<u8,i32>, k: i32) -> bool{
        let values: Vec<i32> = map.values().copied().collect();
        let values_sum: i32 = values.iter().sum();
        let no_mods = values.len() == 1;

        let mut max_key: u8 = 0;
        let mut max_val: i32 = 0;
        for (key,val) in map.iter(){
            if *val > max_val{
                max_key = *key;
                max_val = *val;
            }
        }
        let can_exchange = values_sum - max_val <= k;
        return !(can_exchange || no_mods)
    }


}
