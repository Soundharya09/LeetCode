class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int[] rev = new int[n];

        for (int i = 0; i < n; i++) {
            rev[i] = nums[n - 1 - i];
        }
        int t0 = targetShift(nums);
        int t1 = targetShift(rev);

        if (t0 == -1 && t1 == -1) return -1;
        int[] dist = new int[2 * n];
        Arrays.fill(dist, -1);
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        dist[0] = 0;
        queue.add(0);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int type = cur / n;
            int shift = cur % n;
            int next1 = type * n + (shift + 1) % n;
            if (dist[next1] == -1) {
                dist[next1] = dist[cur] + 1;
                queue.add(next1);
            }
            int next2 = (1 - type) * n + (n - shift) % n;
            if (dist[next2] == -1) {
                dist[next2] = dist[cur] + 1;
                queue.add(next2);
            }
        }
        int ans = Integer.MAX_VALUE;
        if (t0 != -1 && dist[t0] != -1) ans = Math.min(ans, dist[t0]);
        if (t1 != -1 && dist[n + t1] != -1) ans = Math.min(ans, dist[n + t1]);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    private int targetShift(int[] arr) {
        int n = arr.length;
        int p = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                p = i;
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[(p + i) % n] != i) return -1;
        }
        return p;
    }
}