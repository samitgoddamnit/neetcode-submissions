class Solution {
    public int numDecodings(String s) {
        System.out.println(s);
        int[] cache = new int[s.length()];
        Arrays.fill(cache,-1);
        return dp(s,0,cache);
    }

    private int dp(String s, int i,int[] cache){
        // System.out.println(i);
        if (i >= s.length()){
            return 1;
        }

        if(cache[i] != -1){
            return cache[i];
        }

        int branchOne = 0;
        int branchTwo = 0;

        int charaOne = -1;
        int charaTwo = -1;

        if(i+1 <= s.length()){
            charaOne = Integer.parseInt(s.substring(i,i+1));
        }

        if(i + 2 <= s.length()){
            charaTwo = Integer.parseInt(s.substring(i,i+2));
        }
        // System.out.println("1 digit: "+charaOne+" 2 digit: "+charaTwo);

        if(charaOne > 0){
            branchOne = dp(s,i+1,cache);
            // System.out.println("left branch found: " + branchOne);
            if(charaTwo >= 10 && charaTwo <= 26){
                branchTwo = dp(s,i+2,cache);
                // System.out.println("right branch found: " + branchOne);
            }
        }
        cache[i] = branchOne + branchTwo;
        return cache[i];
    }
}
