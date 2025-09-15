class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int maxArea = 0;
        while(i < j) {
            int a = Math.min(height[i], height[j]) * (j - i);
            maxArea = Math.max(maxArea, a);
            if(height[i] < height[j]) i++;
            else j--;
        }
        return maxArea;
    }
}