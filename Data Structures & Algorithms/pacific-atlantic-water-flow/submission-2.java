class Solution {

    private int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};


    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Boolean[][] cachePac = new Boolean[heights.length][heights[0].length];
        Boolean[][] cacheAtl = new Boolean[heights.length][heights[0].length];
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < heights.length; i++){
            for(int j = 0; j < heights[i].length; j++){
                if(canReachPac(heights,i,j,cachePac) && canReachAtl(heights,i,j,cacheAtl)){
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;
    }

    private boolean canReachPac(int[][] heights, int i, int j, Boolean[][] cache){
        if(cache[i][j] != null){
            return cache[i][j];
        }

        if(i == 0 || j == 0){
            cache[i][j] = true;
            // System.out.println("found a tile that can reach the pac");
            return cache[i][j];
        }

        cache[i][j] = false;
        for(int[] direction : directions){
            int row = i + direction[0];
            int column = j + direction[1];
            if(row >= 0 && row < heights.length && column >= 0 && column < heights[row].length){
                if(heights[row][column] <= heights[i][j]){
                    cache[i][j] = cache[i][j] || canReachPac(heights,row,column,cache);
                }
            }
        }
        return cache[i][j];
    }


    private boolean canReachAtl(int[][] heights, int i, int j, Boolean[][] cache){
        if(cache[i][j] != null){
            return cache[i][j];
        }

        if(i == heights.length - 1 || j == heights[i].length - 1){
            cache[i][j] = true;
            // System.out.println("found a tile that can reach the atl");
            return cache[i][j];
        }

        cache[i][j] = false;
        for(int[] direction : directions){
            int row = i + direction[0];
            int column = j + direction[1];
            if(row >= 0 && row < heights.length && column >= 0 && column < heights[row].length){
                if(heights[row][column] <= heights[i][j]){
                    cache[i][j] = cache[i][j] || canReachAtl(heights,row,column,cache);
                }
            }
        }
        return cache[i][j];
    }
}
