class Solution {
    public int[] finalPrices(int[] prices) {
        // APPROACH - 1 -> BRUTE FORCE 
        // int n = prices.length;
        // int[] ans = new int[n];
        // for(int i = 0; i < n; i++) {
        //     ans[i] = prices[i];
        //     for(int j = i + 1; j < n; j++) {
        //         if(prices[j] <= prices[i]) {
        //             ans[i] = prices[i] - prices[j];
        //             break;
        //         }
        //     }
        // }
        // return ans;

        // APPROACH - 2 -> MONOTONIC STACK
        int n = prices.length;
        int[] ans = prices.clone();
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && prices[st.peek()] >= prices[i]) {
                int idx = st.pop();
                ans[idx] = prices[idx] - prices[i];
            }
            st.push(i);
        }
        return ans;
    }
}