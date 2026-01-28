class RangeFreqQuery {
    private Map<Integer, List<Integer>> indexMap;

    public RangeFreqQuery(int[] arr) {
        indexMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            indexMap.putIfAbsent(arr[i], new ArrayList<>());
            indexMap.get(arr[i]).add(i);
        }
    }
    
    public int query(int left, int right, int value) {
        if (!indexMap.containsKey(value)) return 0;
        List<Integer> indices = indexMap.get(value);
        int leftPos = binarySearchLeft(indices, left);
        int rightPos = binarySearchRight(indices, right);
        return rightPos - leftPos;
    }

    public int binarySearchLeft(List<Integer> list, int target) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
    
    public int binarySearchRight(List<Integer> list, int target) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) <= target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */