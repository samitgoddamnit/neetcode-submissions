impl Solution {
    pub fn check_inclusion(s1: String, s2: String) -> bool {
        let mut s1_counts: HashMap<u8,i32> = HashMap::new();
        let mut s2_counts: HashMap<u8,i32> = HashMap::new();
        let s1 = s1.as_bytes();
        let s2 = s2.as_bytes();

        for c in s1{
            s1_counts.entry(*c).and_modify(|total| *total += 1).or_insert(1);
        }

        println!("{:?}",s1_counts);

        let mut l = 0;
        for r in 0..s2.len(){
            if r - l + 1 > s1.len(){
                println!("l: {}, r: {}",l,r);
                s2_counts.entry(s2[l]).and_modify(|c| *c -= 1);
                if *s2_counts.get(&s2[l]).unwrap() == 0{
                    s2_counts.remove(&s2[l]);
                }
                l += 1;
            }
            s2_counts.entry(s2[r]).and_modify(|total| *total += 1).or_insert(1);
            if s2_counts == s1_counts{
                return true;
            }
            println!("{:?}",s2_counts);
        }
        return false;

    }
}
