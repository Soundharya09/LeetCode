class Solution {
    public boolean isPossible(int[] target) {
        if(target.length == 1) return target[0] == 1;
        PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long totalSum = 0;
        for(int num : target) {
            maxHeap.offer((long) num);
            totalSum += num;
        }
        while(maxHeap.peek() > 1) {
            long large = maxHeap.poll();
            long restSum = totalSum - large;

            if(restSum == 0 || restSum >= large) return false;
            if(restSum == 1) return true;

            long prevVal = large % restSum;
            if(prevVal == 0) prevVal = restSum;

            totalSum = restSum + prevVal;
            maxHeap.offer(prevVal);
        }
        return true;
    }
}