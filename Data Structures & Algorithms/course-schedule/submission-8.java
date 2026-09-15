class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,List<Integer>> mappings = new HashMap();
        for(int i = 0; i < prerequisites.length; i++){
            if(mappings.get(prerequisites[i][1]) == null){
                mappings.put(prerequisites[i][1],new ArrayList());
            }
            mappings.get(prerequisites[i][1]).add(prerequisites[i][0]);
            if(!no_cycle(mappings,prerequisites[i][1],new HashSet())){
                return false;
            }
        }
        // everytime you add a new edge to the dependency graph, you check
        // whether that addition caused a cycle.
        // this has a bad time complexity, rewrite this solution.

        return true;
    }


    private boolean no_cycle(HashMap<Integer,List<Integer>> mappings, int key, HashSet<Integer> visited){
        if(visited.contains(key)){
            //found a cycle
            return false;
        }
        visited.add(key);
        if(mappings.get(key) == null){
            //end of tree / graph
            visited.remove(key);
            return true;
        }
        List<Integer> adjacent = mappings.get(key);
        for(int i = 0; i < adjacent.size(); i++){
            if(!no_cycle(mappings,adjacent.get(i),visited)){
                return false;
            }
        }
        visited.remove(key);
        return true;
    }
}
