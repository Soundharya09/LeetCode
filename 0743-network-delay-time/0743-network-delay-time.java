class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            graph.computeIfAbsent(time[0], x -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, k});
        Map<Integer, Integer> dist = new HashMap<>();
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0], node = curr[1];
            if (dist.containsKey(node)) continue;
            dist.put(node, d);
            if (graph.containsKey(node)) {
                for (int[] neighbor : graph.get(node)) {
                    int nextNode = neighbor[0], weight = neighbor[1];
                    if (!dist.containsKey(nextNode)) {
                        pq.offer(new int[]{d + weight, nextNode});
                    }
                }
            }
        }
        if (dist.size() != n) return -1;
        int maxDelay = 0;
        for (int d : dist.values()) {
            maxDelay = Math.max(maxDelay, d);
        }
        return maxDelay;
    }
}