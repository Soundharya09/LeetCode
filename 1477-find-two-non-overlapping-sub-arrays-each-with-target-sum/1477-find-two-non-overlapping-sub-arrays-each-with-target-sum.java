class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] best = new int[n];
        int INF = Integer.MAX_VALUE / 2;
        int left = 0, sum = 0;
        int result = INF;
        int bestSoFar = INF;

        for (int right = 0; right < n; right++) {
            sum += arr[right];
            while (sum > target) {
                sum -= arr[left];
                left++;
            }
            if (sum == target) {
                int len = right - left + 1;
                if (left > 0 && best[left - 1] < INF) {
                    result = Math.min(result, best[left - 1] + len);
                }
                bestSoFar = Math.min(bestSoFar, len);
            }
            best[right] = bestSoFar;
        }
        return result >= INF ? -1 : result;
    }
}