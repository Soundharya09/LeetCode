class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        PriorityQueue<Integer> leftHeap = new PriorityQueue<>();
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>();

        int left = 0;
        int right = n - 1;

        while (left < candidates && left <= right) {
            leftHeap.offer(costs[left++]);
        }
        while (right >= n - candidates && right >= left) {
            rightHeap.offer(costs[right--]);
        }

        long total = 0;
        for (int i = 0; i < k; i++) {
            if (rightHeap.isEmpty() || (!leftHeap.isEmpty() && leftHeap.peek() <= rightHeap.peek())) {
                total += leftHeap.poll();
                if (left <= right) leftHeap.offer(costs[left++]);
            } 
            else {
                total += rightHeap.poll();
                if (left <= right) rightHeap.offer(costs[right--]);
            }
        }
        return total;
    }
}