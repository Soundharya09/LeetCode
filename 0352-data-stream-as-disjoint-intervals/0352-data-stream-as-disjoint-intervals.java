class SummaryRanges {
    private TreeMap<Integer, Integer> intervals;

    public SummaryRanges() {
        intervals = new TreeMap<>();
    }
    
    public void addNum(int value) {
        Integer start = intervals.floorKey(value);
        if (start != null && intervals.get(start) >= value) return;
        boolean mergeLeft = (start != null && intervals.get(start) == value - 1);
        Integer next = intervals.ceilingKey(value);
        boolean mergeRight = (next != null && next == value + 1);
        if (mergeLeft && mergeRight) {
            intervals.put(start, intervals.get(next));
            intervals.remove(next);
        } 
        else if (mergeLeft) intervals.put(start, value);
        else if (mergeRight) {
            intervals.put(value, intervals.get(next));
            intervals.remove(next);
        } 
        else intervals.put(value, value);
    }
    
    public int[][] getIntervals() {
        int[][] result = new int[intervals.size()][2];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : intervals.entrySet()) {
            result[i][0] = entry.getKey();
            result[i][1] = entry.getValue();
            i++;
        }
        return result;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */