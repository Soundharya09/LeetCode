class RandomizedCollection {
    private List<Integer> nums;
    private Map<Integer, Set<Integer>> indices;
    private Random rand;

    public RandomizedCollection() {
        nums = new ArrayList<>();
        indices = new HashMap<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        boolean notPresent = !indices.containsKey(val);
        
        indices.putIfAbsent(val, new HashSet<>());
        indices.get(val).add(nums.size());
        nums.add(val);
        
        return notPresent;
    }
    
    public boolean remove(int val) {
        if (!indices.containsKey(val) || indices.get(val).isEmpty()) return false;
        
        int removeIdx = indices.get(val).iterator().next();
        indices.get(val).remove(removeIdx);
        
        int lastElement = nums.get(nums.size() - 1);
        nums.set(removeIdx, lastElement);
        
        indices.get(lastElement).add(removeIdx);
        indices.get(lastElement).remove(nums.size() - 1);
        
        nums.remove(nums.size() - 1);
        
        if (indices.get(val).isEmpty()) indices.remove(val);
        
        return true;
    }
    
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */