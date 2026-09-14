class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList();

        for(int i = 0; i < heights.length; i++){
            for(int j = 0; j < heights[i].length; j++){

                boolean pacific = dfs(i,j,heights,Integer.MAX_VALUE,true,new HashSet());
                boolean atlantic = dfs(i,j,heights,Integer.MAX_VALUE,false,new HashSet());

                // System.out.println("coordinates tested are i:" + i + ", j:" + j);
                // System.out.println(pacific);
                // System.out.println(atlantic);

                if(pacific && atlantic){
                    result.add(Arrays.asList(i,j));
                }
            }
        }

        return result;
    }

    private boolean dfs(int i, int j, int[][] heights, int previous_height, boolean pacific, HashSet<Pair<Integer,Integer>> visited){
        Pair<Integer,Integer> coords = new Pair(i,j);
        if(visited.contains(coords)){
            return false;
        }
        if(pacific){
            //pacific
            if(i < 0){
                return true;
            }
            if(i >= heights.length){
                return false;
            }
            if(j < 0){
                return true;
            }
            if(j >= heights[i].length){
                return false;
            }
        }else{
            //atlantic
            if(i >= heights.length){
                return true;
            }
            if (i < 0){
                return false;
            }
            if(j >= heights[i].length){
                return true;
            }
            if(j < 0){
                return false;
            }
        }

        int height = heights[i][j];

        if(heights[i][j] > previous_height){
            return false;
        }

        visited.add(coords);

        return dfs(i+1,j,heights,height,pacific,visited) ||
        dfs(i-1,j,heights,height,pacific,visited) ||
        dfs(i,j+1,heights,height,pacific,visited) || 
        dfs(i,j-1,heights,height,pacific,visited);
    }
}
