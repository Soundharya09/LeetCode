class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea = 0, n = heights.length;
        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && heights[i] < heights[st.peek()]) {
                int height = heights[st.pop()];
                int width = st.isEmpty() ? i : i - st.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            int height = heights[st.pop()];
            int width = st.isEmpty() ? n : n - st.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }
        return maxArea;
    }
}