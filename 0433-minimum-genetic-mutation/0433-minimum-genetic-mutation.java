class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(endGene)) return -1;
        
        char[] chars = {'A', 'C', 'G', 'T'};
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(startGene);
        visited.add(startGene);
        
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(endGene)) return steps;
                
                char[] currArr = current.toCharArray();
                for (int j = 0; j < currArr.length; j++) {
                    char original = currArr[j];
                    for (char c : chars) {
                        if (c == original) continue;
                        currArr[j] = c;
                        String mutated = new String(currArr);
                        if (bankSet.contains(mutated) && !visited.contains(mutated)) {
                            visited.add(mutated);
                            queue.offer(mutated);
                        }
                    }
                    currArr[j] = original;
                }
            }
            steps++;
        }
        return -1;
    }
}