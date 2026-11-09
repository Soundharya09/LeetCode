class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> available = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            available.add(i);
        }
        PriorityQueue<long[]> busy = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));

        int[] count = new int[k];

        for (int i = 0; i < arrival.length; i++) {
            long time = arrival[i];
            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                available.add((int) busy.poll()[1]);
            }
            if (available.isEmpty()) continue;
            Integer server = available.ceiling(i % k);
            if (server == null) server = available.first();

            available.remove(server);
            count[server]++;
            busy.offer(new long[]{time + load[i], server});
        }
        int max = 0;
        for (int c : count) max = Math.max(max, c);

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (count[i] == max) result.add(i);
        }
        return result;
    }
}