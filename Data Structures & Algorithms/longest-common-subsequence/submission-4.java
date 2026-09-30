class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        //did not understand this at ALL, needed hints and AI, you NEED to understand this before you move on.
        return dp(text1,text2,0,0,new Integer[text1.length()][text2.length()]);
    }

    private int dp(String text1,String text2,int i, int j, Integer[][] cache){
        if(i >= text1.length() || j >= text2.length()){
            return 0;
        }

        if(cache[i][j] != null){
            return cache[i][j];
        }

        if(text1.charAt(i) == text2.charAt(j)){
            // System.out.println(i);
            // System.out.println(j);
            // System.out.println("found");
            cache[i][j] = 1+ dp(text1,text2,i+1,j+1,cache);
            return cache[i][j];
        }
        // System.out.println("current is " + i+ ", " + j);
        // System.out.println("testing " + (i+1) + ", " + j);
        cache[i][j] = Math.max(dp(text1,text2,i+1,j,cache),dp(text1,text2,i,j+1,cache));
        // System.out.println(cache[i][j]);
        return cache[i][j];
    }
}
