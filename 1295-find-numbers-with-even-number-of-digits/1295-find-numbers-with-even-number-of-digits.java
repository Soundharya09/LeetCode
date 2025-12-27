class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int num : nums) {
            int x = String.valueOf(num).length(); //convert int to string -> 345 = "345" = 3. This string count will be stored in x.
            if(x % 2 == 0) count++;
        }
        return count;
    }
}