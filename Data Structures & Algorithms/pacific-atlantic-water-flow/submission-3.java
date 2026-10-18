class Solution {

    private int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};


    //coded a dynamic programming solution
    //turns out it's wrong because of cycles maybe ? I'm not sure why
    //ok figured it out, you can reuse a lot of this structure, but you need to do the reverse dfs idea,
    //and cache marks all visited tiles

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] cachePac = new boolean[heights.length][heights[0].length];
        boolean[][] cacheAtl = new boolean[heights.length][heights[0].length];
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < heights[0].length; i++){
            canReachPac(heights,0,i,cachePac);
        }

        for(int i = 0; i < heights.length; i++){
            canReachPac(heights,i,0,cachePac);
        }

        for(int i = 0; i < heights[0].length; i++){
            canReachAtl(heights,heights.length - 1,i,cacheAtl);
        }

        for(int i = 0; i < heights.length; i++){
            canReachAtl(heights,i,heights[i].length - 1,cacheAtl);
        }

        for(int i = 0; i < heights.length; i++){
            for(int j = 0; j < heights[i].length; j++){
                if(cachePac[i][j] && cacheAtl[i][j]){
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;
    }

    private void canReachPac(int[][] heights, int i, int j, boolean[][] cache){
        if(cache[i][j] == true){
            return;
        }
        cache[i][j] = true;
        for(int[] direction : directions){
            int row = i + direction[0];
            int column = j + direction[1];
            if(row >= 0 && row < heights.length && column >= 0 && column < heights[row].length){
                if(heights[row][column] >= heights[i][j]){
                    canReachPac(heights,row,column,cache);
                }
            }
        }
    }


    private void canReachAtl(int[][] heights, int i, int j, boolean[][] cache){
        if(cache[i][j] == true){
            return;
        }
        cache[i][j] = true;
        for(int[] direction : directions){
            int row = i + direction[0];
            int column = j + direction[1];
            if(row >= 0 && row < heights.length && column >= 0 && column < heights[row].length){
                if(heights[row][column] >= heights[i][j]){
                    canReachAtl(heights,row,column,cache);
                }
            }
        }
    }
}
