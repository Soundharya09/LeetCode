class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        // int n = heights.length;
        // int[] answer = new int[n];
        // Deque<Integer> stack = new ArrayDeque<>();
        // for (int i = n - 1; i >= 0; i--) {
        //     int count = 0;
        //     while (!stack.isEmpty() && stack.peek() < heights[i]) {
        //         stack.pop();
        //         count++;
        //     }
        //     if (!stack.isEmpty()) count++;
            
        //     answer[i] = count;
        //     stack.push(heights[i]);
        // }
        // return answer;
        int n = heights.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && heights[st.peek()] <= heights[i]) {
                res[st.peek()]++;
                st.pop();
            }
            if(!st.isEmpty()) res[st.peek()]++;
            st.push(i);
        }
        return res;
    }
}