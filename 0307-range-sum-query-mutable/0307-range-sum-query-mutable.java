class NumArray {
    private int[] nums;
    private int[] bit;  
    private int n;

    public NumArray(int[] nums) {
        this.n = nums.length;
        this.nums = new int[n];
        this.bit = new int[n + 1];
        for (int i = 0; i < n; i++) {
            this.nums[i] = nums[i];
            init(i, nums[i]);
        }
    }

    public void init(int index, int val) {
        int i = index + 1;  
        while (i <= n) {
            bit[i] += val;
            i += i & -i;  
        }
    }
    
    public void update(int index, int val) {
        int diff = val - nums[index];
        nums[index] = val;
        int i = index + 1;  
        while (i <= n) {
            bit[i] += diff;
            i += i & -i;
        }
    }

    public int prefixSum(int index) {
        int sum = 0;
        int i = index + 1;  
        while (i > 0) {
            sum += bit[i];
            i -= i & -i;  
        }
        return sum;
    }
    
    public int sumRange(int left, int right) {
        return prefixSum(right) - prefixSum(left - 1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */