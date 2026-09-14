class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair<Pair<Integer,Integer>,Integer>> queue = new LinkedList();
        int fresh_count = 0;
        int minutes = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 2){
                    queue.add(new Pair(new Pair(i,j),0));
                }
                if(grid[i][j] == 1){
                    fresh_count += 1;
                }
            }
        }

        if(fresh_count == 0){
            return 0;
        }

        if(queue.isEmpty()){
            return -1;
        }

        // System.out.println("about to start bfsing");

        while(!queue.isEmpty()){
            Pair<Pair<Integer,Integer>,Integer> item = queue.poll();
            Pair<Integer,Integer> position = item.getKey();
            int level = item.getValue();
            int i = position.getKey();
            int j = position.getValue();
            if(i < 0 || i >= grid.length){
                continue;
            }
            if(j < 0 || j >= grid[i].length){
                continue;
            }
            if(grid[i][j] == 0){
                continue;
            }
            // System.out.println("i is : "+ i +", j is : "+ j);
            if(grid[i][j] == 1){
                grid[i][j] = 2;
                fresh_count -= 1;
                if(fresh_count == 0){
                    return level;
                }
                queue.add(new Pair(new Pair(i,j+1),level + 1));
                queue.add(new Pair(new Pair(i,j-1),level + 1));
                queue.add(new Pair(new Pair(i+1,j),level + 1));
                queue.add(new Pair(new Pair(i-1,j),level + 1));
            }

            if(level == 0){
                queue.add(new Pair(new Pair(i,j+1),level + 1));
                queue.add(new Pair(new Pair(i,j-1),level + 1));
                queue.add(new Pair(new Pair(i+1,j),level + 1));
                queue.add(new Pair(new Pair(i-1,j),level + 1));
            }
        }
        return -1;
    }
}
