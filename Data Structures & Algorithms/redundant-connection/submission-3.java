class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        // HashMap<Integer,List<Integer>> graph = new HashMap();
        int[] result = new int[2];
        HashSet<Integer> connected = new HashSet();
        HashMap<Integer,List<Integer>> graph = new HashMap();

        for(int i = 0; i < edges.length; i++){


            if(!connected.contains(edges[i][0])){
                connected.add(edges[i][0]);
            }
            if(!connected.contains(edges[i][1])){
                connected.add(edges[i][1]);
            }
            if(graph.get(edges[i][0]) == null){
                graph.put(edges[i][0],new ArrayList());
            }

            if(graph.get(edges[i][1]) == null){
                graph.put(edges[i][1],new ArrayList());
            }

            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);

            if(connected.contains(edges[i][0]) && connected.contains(edges[i][1])){
                // System.out.println(edges[i][0] + "" + edges[i][1]);
                if(!no_cycle(graph,new HashSet(),edges[i][0],null)){
                    return edges[i];
                }
            }

        }

        return result;
    }

    private boolean no_cycle(HashMap<Integer,List<Integer>> graph, HashSet<Integer> visited,int value,Integer parent){
        if(visited.contains(value)){
            return false;
        }
        visited.add(value);

        if(graph.get(value) == null){
            return true;
        }

        List<Integer> adjacent = graph.get(value);
        // System.out.println(adjacent);
        // System.out.println(parent);
        for(int i = 0; i < adjacent.size(); i++){
            if(adjacent.get(i) == parent){
                continue;
            }
            if(!no_cycle(graph,visited,adjacent.get(i),value)){
                return false;
            }
        }
        visited.remove(value);
        return true;
    }
}
