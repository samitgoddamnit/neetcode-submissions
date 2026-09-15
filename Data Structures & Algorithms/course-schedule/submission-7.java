class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,List<Integer>> mappings = new HashMap();
        HashSet<Integer> descendents = new HashSet();
        for(int i = 0; i < prerequisites.length; i++){
            if(mappings.get(prerequisites[i][1]) == null){
                mappings.put(prerequisites[i][1],new ArrayList());
            }
            mappings.get(prerequisites[i][1]).add(prerequisites[i][0]);
            if(!descendents.contains(prerequisites[i][0])){
                descendents.add(prerequisites[i][0]);
            }
            if(!no_cycle(mappings,prerequisites[i][1],new HashSet())){
                return false;
            }
        }

        // List<Integer> starts = new ArrayList();
        // for(int i = 0; i < numCourses; i++){
        //     if(!descendents.contains(i)){
        //         starts.add(i);
        //     }
        // }

        // if(starts.size() == 0){
        //     return false;
        // }

        // System.out.println(starts);
 
        // //starts have no ancestors - can be learned without a prerequisite.

        // //you can't learn everything if something in the graph has a circular dependency - you're searching for cycles essentially.

        // for(int i = 0; i < starts.size(); i++){
        //     if(!no_cycle(mappings,starts.get(i),new HashSet())){
        //         return false;
        //     }
        // }
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
