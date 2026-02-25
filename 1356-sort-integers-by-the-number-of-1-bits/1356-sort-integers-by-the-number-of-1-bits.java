class Pair {
    int num;
    int count;

    Pair(int num, int count) {
        this.num = num;
        this.count = count;
    }
}
class Solution {
    public int[] sortByBits(int[] arr) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.count==b.count?a.num-b.num:a.count-b.count);
        for(int i = 0;i < arr.length; i++){
            int setbit = Integer.bitCount(arr[i]);
            pq.add(new Pair(arr[i],setbit));
        }
        int k = 0;
        int[] ans =  new int[arr.length];
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            ans[k++] = p.num;
        }
        return ans;
    }
}