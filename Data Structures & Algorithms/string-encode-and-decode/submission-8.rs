impl Solution {
    pub fn encode(strs: Vec<String>) -> String {
        //encode each string as a sequence of [char](frequency) (runLength encoding)!
        //(massively overcomplicated this)

        let mut fullEncoding = format!("{}##", strs.len()); 
        let mut string_iter = strs.iter().peekable();
        while let Some(string) = string_iter.next(){

            let mut iter = string.chars().peekable();

            let mut wordEncoding: String = String::new();
            let mut count: u32 = 0;

            while let Some(c) = iter.next(){
                let next: char = *iter.peek().unwrap_or(&'終');

                count += 1;
                if !(c == next){
                    let runEncoding = format!("[{}]({})",c,count);
                    count = 0;
                    wordEncoding = wordEncoding + &runEncoding;
                }
            }
            if !string_iter.peek().is_none(){
                wordEncoding = wordEncoding + "££";
            }
            fullEncoding = fullEncoding + &wordEncoding;
        }
        fullEncoding
    }

    pub fn decode(s: String) -> Vec<String> {
        let parts = s.split("##");
        let collection: Vec<&str> = parts.collect();
        let vecCount: u32 = collection[0].parse().unwrap();
        let parts = collection[1].split("££");

        let mut decoded_strs: Vec<String> = Vec::new();
        let mut partCount: u32 = 0; 
        for part in parts{
            let mut iter = part.chars().peekable();
            let mut currChar: char = 'x';
            let mut count: String = String::new();
            let mut parsing: String = String::from("char");
            let mut run: String = String::new();
            while let Some(c) = iter.next(){
                let next: char = *iter.peek().unwrap_or(&'終');
                if parsing == "char"{
                    if c == '['{
                        if !(c==currChar){
                            currChar = next;
                        }
                    }
                    else if c == ']' && next == '('{
                        parsing = String::from("num");
                    }
                }
                else if parsing == "num"{
                    if c != ')' {
                        if next != ')'{

                            count.push(next);
                        }
                    }
                    else{
                        let runLength: u32 = count.parse().unwrap(); 


                        for _i in 0..runLength{
                           run.push(currChar);
                        }


                        count = String::new();

                        if next == '['{

                            parsing = String::from("char");
                        }
                    }
                }
            }


            decoded_strs.push(run);
        }
        if vecCount == 0{
            return Vec::<String>::new();
        }
        else{
            return decoded_strs;
        }
    }

}
