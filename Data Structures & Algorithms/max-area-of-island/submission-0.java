class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1){
                    max = Math.max(max,dfs(grid,i,j));
                }
            }
        }
        return max;
    }

    private int dfs(int[][] grid,int i, int j){
        
        if(i < 0 || i >= grid.length){
            return 0;
        }
        if(j < 0 || j >= grid[i].length){
            return 0;
        }
        
        if(grid[i][j] == 1){
            grid[i][j] = 0;
            return dfs(grid,i+1,j) + dfs(grid,i-1,j) + dfs(grid,i,j+1) + dfs(grid,i,j-1) + 1;
        }

        return 0;
    }
}
