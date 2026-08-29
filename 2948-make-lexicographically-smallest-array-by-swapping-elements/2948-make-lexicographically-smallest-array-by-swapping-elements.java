class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[][] sortedNums = new int[n][2];
        for (int i = 0; i < n; i++) {
            sortedNums[i] = new int[]{nums[i], i};
        }
        Arrays.sort(sortedNums, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<List<int[]>> components = new ArrayList<>();
        List<int[]> currentComponent = new ArrayList<>();
        currentComponent.add(sortedNums[0]);
        
        for (int i = 1; i < n; i++) {
            if (sortedNums[i][0] - sortedNums[i - 1][0] <= limit) {
                currentComponent.add(sortedNums[i]);
            } 
            else {
                components.add(new ArrayList<>(currentComponent));
                currentComponent.clear();
                currentComponent.add(sortedNums[i]);
            }
        }
        components.add(currentComponent);
        
        int[] result = new int[n];
        for (List<int[]> component : components) {
            List<Integer> indices = new ArrayList<>();
            List<Integer> values = new ArrayList<>();
            
            for (int[] pair : component) {
                indices.add(pair[1]);
                values.add(pair[0]);
            }
            
            Collections.sort(indices);
            Collections.sort(values);
            
            for (int i = 0; i < indices.size(); i++) {
                result[indices.get(i)] = values.get(i);
            }
        }
        return result;
    }
}