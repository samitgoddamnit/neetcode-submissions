impl Solution {
    pub fn min_window(s: String, t: String) -> String {
        let t = t.as_bytes();
        let s = s.as_bytes();
        let mut t_counts: HashMap<u8,i32> = HashMap::new();
        let mut s_counts: HashMap<u8,i32> = HashMap::new();
        
        for c in t{
            t_counts.entry(*c).and_modify(|counts| *counts += 1).or_insert(1);
        }
        println!("{:?}",t_counts);

        let mut l = 0;
        let mut min = s.len();
        let mut min_l_index = 0;
        let mut min_r_index = 0;

        for r in 0..s.len(){
            s_counts.entry(s[r]).and_modify( |total| *total += 1).or_insert(1);
            // println!("l: {}, r: {}",l,r);
            while Self::check_substring(&s_counts,&t_counts){
                // println!("l: {}, r: {}",l,r);
                if r - l + 1 <= min{
                    min = r - l + 1;
                    min_l_index = l;
                    min_r_index = r + 1;
                }
                // println!("{:?}",min);
                s_counts.entry(s[l]).and_modify(|counts| *counts -= 1);
                if *s_counts.get(&s[l]).unwrap() == 0{
                    s_counts.remove(&s[l]);
                }
                l += 1;
            }
        }
        // println!("returning");
        // println!("l: {}, r: {}",min_l_index,min_r_index);
        let res = str::from_utf8(&s[min_l_index..min_r_index]).unwrap().to_string();
        return res;
    }

    fn check_substring(s_counts:&HashMap<u8,i32>,t_counts:&HashMap<u8,i32>) -> bool{
        for (key,val) in t_counts.iter(){
            let Some(s_value) = s_counts.get(key) else{ return false;};
            if !(s_value >= val){
                return false;
            }
        }
        true
    }
}
