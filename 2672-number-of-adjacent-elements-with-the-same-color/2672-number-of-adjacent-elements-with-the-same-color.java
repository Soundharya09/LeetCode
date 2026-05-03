class Solution {
    public int[] colorTheArray(int n, int[][] queries) {
        int[] colors = new int[n];
        int[] answer = new int[queries.length];
        int count = 0;

        for (int q = 0; q < queries.length; q++) {
            int idx = queries[q][0];
            int col = queries[q][1];
            if (colors[idx] != 0) {
                if (idx > 0 && colors[idx - 1] == colors[idx]) count--;
                if (idx < n - 1 && colors[idx + 1] == colors[idx]) count--;
            }
            colors[idx] = col;
            if (idx > 0 && colors[idx - 1] == colors[idx]) count++;
            if (idx < n - 1 && colors[idx + 1] == colors[idx]) count++;

            answer[q] = count;
        }
        return answer;
    }   
}