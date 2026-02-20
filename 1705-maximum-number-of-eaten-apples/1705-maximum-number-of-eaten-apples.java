class Solution {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int n = apples.length;
        int eaten = 0, day = 0;
        while(day < n || !pq.isEmpty()) {
            if(day < n && apples[day] > 0)  pq.offer(new int[]{day + days[day], apples[day]});
            while (!pq.isEmpty() && pq.peek()[0] <= day) pq.poll();
            if (!pq.isEmpty()) {
                int[] top = pq.peek();
                top[1]--;
                if (top[1] == 0) pq.poll();
                eaten++;
            }
            day++;
        }
        return eaten;
    }
}