impl Solution {
    pub fn is_anagram(s: String, t: String) -> bool {
        let mut smap: HashMap<char,usize> = HashMap::new();
        let mut tmap: HashMap<char,usize> = HashMap::new();
        for ch in s.chars(){
            let count = smap.entry(ch).or_insert(0);
            *count += 1;
        }

        for ch in t.chars(){
            let count = tmap.entry(ch).or_insert(0);
            *count += 1;
        }

        if tmap == smap {true} else {false}
    }
}
