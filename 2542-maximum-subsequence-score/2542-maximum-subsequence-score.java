class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;
        Arrays.sort(idx, (a, b) -> nums2[b] - nums2[a]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum = 0;
        long ans = 0;

        for (int i = 0; i < n; i++) {
            int id = idx[i];
            sum += nums1[id];
            pq.offer(nums1[id]);

            if (pq.size() > k) sum -= pq.poll();
            if (pq.size() == k) ans = Math.max(ans, sum * (long) nums2[id]);
        }
        return ans;
    }
}