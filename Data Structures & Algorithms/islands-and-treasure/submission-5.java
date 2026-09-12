class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<Pair<Integer,Integer>> queue = new LinkedList();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 0){
                    queue.add(new Pair(i,j));
                }
            }
        }
        grid = bfs(grid,queue);
    }


    private int[][] bfs(int[][] grid, Queue<Pair<Integer,Integer>> treasureQueue){
        Queue<Pair<Pair<Integer,Integer>,Integer>> queue = new LinkedList();
        HashSet<Pair<Integer,Integer>> visited = new HashSet();
        while(!treasureQueue.isEmpty()){
            Pair<Integer,Integer> tmp = treasureQueue.poll();
            queue.add(new Pair(tmp,0));
        }

        while (!queue.isEmpty()){
            Pair<Pair<Integer,Integer>,Integer> current = queue.poll();
            int curr_i = current.getKey().getKey();
            int curr_j = current.getKey().getValue();
            int level = current.getValue();
            if(visited.contains(current.getKey())){
                continue;
            }
            if(curr_i < 0 || curr_i >= grid.length){
                continue;
            }
            if(curr_j < 0 || curr_j >= grid[curr_i].length){
                continue;
            }
            int value = grid[curr_i][curr_j];
            if(value == -1){
                continue;
            }
            if(value >= 0){
                if(value > 0){
                    grid[curr_i][curr_j] = Math.min(level,grid[curr_i][curr_j]);
                }
                visited.add(current.getKey());
                queue.add(new Pair(new Pair(curr_i+1,curr_j),level + 1));
                queue.add(new Pair(new Pair(curr_i-1,curr_j),level + 1));
                queue.add(new Pair(new Pair(curr_i,curr_j+1),level + 1));
                queue.add(new Pair(new Pair(curr_i,curr_j-1),level + 1));
            }
        }
        return grid;
    }
}
