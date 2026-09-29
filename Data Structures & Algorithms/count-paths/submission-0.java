class Solution {
    public int uniquePaths(int m, int n) {
        Integer[][] cache = new Integer[m][n];
        return dfs(0,0,cache,m-1,n-1);
    }


    private int dfs(int r, int c, Integer[][] cache,int m, int n){
        if(r > m || c > n){
            return 0;
        }

        System.out.println("r: "+ r + " c: " + c);
        if(cache[r][c] != null){
            return cache[r][c];
        }

        if(r == m && c == n){
            cache[r][n] = 1;
            return cache[r][c];
        }

        int go_right = dfs(r+1,c,cache,m,n);
        int go_down = dfs(r,c+1,cache,m,n);
        // System.out.println(go_right + go_down);
        cache[r][c] = go_right + go_down;
        return cache[r][c];
    }
}
