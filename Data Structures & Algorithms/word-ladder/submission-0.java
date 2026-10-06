class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair<String,Integer>> queue = new LinkedList<>();
        HashMap<String,List<String>> graph = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        wordList.add(beginWord);
        for(int i = 0; i < wordList.size(); i++){
            graph.put(wordList.get(i),new ArrayList<>());
            for(int j = 0; j < wordList.size(); j++){
                if(i == j){
                    continue;
                }
                if(differByOne(wordList.get(i),wordList.get(j))){
                    graph.get(wordList.get(i)).add(wordList.get(j));
                }
            }
        }

        queue.add(new Pair<String,Integer>(beginWord,1));

        while(!queue.isEmpty()){
            Pair<String,Integer> item = queue.poll();
            if(set.contains(item.getKey())){
                continue;
            }
            if(item.getKey().equals(endWord)){
                return item.getValue();
            }
            set.add(item.getKey());
            List<String> adjacent = graph.get(item.getKey());
            System.out.println(item.getKey());
            System.out.println(adjacent);
            for(int i = 0; i < adjacent.size(); i++){
                queue.add(new Pair<String,Integer>(adjacent.get(i),item.getValue() + 1));
            }
        }
        return 0;
    }

    private boolean differByOne(String a, String b){
        boolean flag = false;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                if(!flag){
                    flag = true;
                }
                else{
                    flag = false;
                    i = a.length();
                }
            }
        }
        return flag;
    }
}
