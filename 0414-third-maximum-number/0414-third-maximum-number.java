public class Solution {
    public int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE, second = Long.MIN_VALUE, third = Long.MIN_VALUE;
        for (int num : nums) {
            if (num > first) {
                third = second;
                second = first;
                first = num;
            } 
            else if (num < first && num > second) {
                third = second;
                second = num;
            }
            else if (num < second && num > third) {
                third = num;
            }
        }
        return (third == Long.MIN_VALUE || third == second) ? (int) first : (int) third;
    }
}