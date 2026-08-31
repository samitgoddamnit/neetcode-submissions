class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] instructionCounts = new int[26];
        for (int i = 0; i < 26; i++){
            instructionCounts[i] = 0;
        }
        Comparator<Pair<Character,Integer>> c  = ((a,b) -> Integer.compare(a.getValue(),b.getValue()));
        PriorityQueue<Pair<Character,Integer>> queue = new PriorityQueue(c);

        int totalCount = tasks.length;
        for(int i = 0; i < tasks.length; i++){
            char tmp = tasks[i];
            int index = tmp - 'A';
            instructionCounts[index] += 1;
            if (instructionCounts[index] == 1){
                queue.add(new Pair(tasks[i],1));
            }
        }
        int cycle = 0;
        while(totalCount > 0){
            cycle += 1;
            Pair<Character,Integer> tmp = queue.peek();
            Integer tmpValue = tmp.getValue();
            Character tmpKey = tmp.getKey();
            if(tmpValue <= cycle){
                int index = tmpKey - 'A';
                instructionCounts[index] -= 1;
                int remaining = instructionCounts[index];
                queue.poll();
                if(remaining > 0){
                    queue.add(new Pair<Character,Integer>(tmpKey, tmpValue + n + 1));
                }
                totalCount -= 1;
            }
        }
        return cycle;
    }
}
