class SmallestInfiniteSet {
    private int current;
    private PriorityQueue<Integer> heap;
    private Set<Integer> added;

    public SmallestInfiniteSet() {
        current = 1;
        heap = new PriorityQueue<>();
        added = new HashSet<>();
    }
    
    public int popSmallest() {
        if (!heap.isEmpty()) {
            int smallest = heap.poll();
            added.remove(smallest);
            return smallest;
        }
        return current++;
    }
    
    public void addBack(int num) {
        if (num < current && !added.contains(num)) {
            heap.offer(num);
            added.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */