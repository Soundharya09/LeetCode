class Solution {
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;
        Arrays.sort(idx, (a, b) -> intervals.get(a).get(1) - intervals.get(b).get(1));

        int[] r = new int[n];
        for (int i = 0; i < n; i++) r[i] = intervals.get(idx[i]).get(1);

        long[][] dp = new long[5][n + 1];
        List<List<Integer>>[] track = new List[5];
        for (int k = 0; k <= 4; k++) {
            track[k] = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                track[k].add(new ArrayList<>());
            }
        }

        for (int k = 1; k <= 4; k++) {
            for (int i = 1; i <= n; i++) {
                dp[k][i] = dp[k][i - 1];
                track[k].set(i, new ArrayList<>(track[k].get(i - 1)));
            }
        }

        for (int k = 1; k <= 4; k++) {
            for (int i = 1; i <= n; i++) {
                List<Integer> cur = intervals.get(idx[i - 1]);
                int l = cur.get(0), weight = cur.get(2);
                int lo = 0, hi = n;
                while (lo < hi) {
                    int mid = (lo + hi + 1) / 2;
                    if (mid <= n && r[mid - 1] < l) lo = mid; else hi = mid - 1;
                }
                int j = lo;
                long candidate = dp[k - 1][j] + weight;
                long without = dp[k][i - 1];
                List<Integer> candList = new ArrayList<>(track[k - 1].get(j));
                candList.add(idx[i - 1]);
                Collections.sort(candList);
                List<Integer> withoutList = track[k].get(i - 1);

                if (candidate > without) {
                    dp[k][i] = candidate;
                    track[k].set(i, candList);
                } else if (candidate == without) {
                    if (compareLists(candList, withoutList) < 0) {
                        dp[k][i] = candidate;
                        track[k].set(i, candList);
                    } else {
                        dp[k][i] = without;
                        track[k].set(i, withoutList);
                    }
                } else {
                    dp[k][i] = without;
                    track[k].set(i, withoutList);
                }
            }
        }

        long maxScore = -1;
        List<Integer> result = new ArrayList<>();
        for (int k = 1; k <= 4; k++) {
            long score = dp[k][n];
            List<Integer> candidate = track[k].get(n);
            if (score > maxScore) {
                maxScore = score;
                result = candidate;
            } else if (score == maxScore) {
                if (compareLists(candidate, result) < 0) {
                    result = candidate;
                }
            }
        }

        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) ans[i] = result.get(i);
        return ans;
    }
    private int compareLists(List<Integer> a, List<Integer> b) {
        int n = Math.min(a.size(), b.size());
        for (int i = 0; i < n; i++) {
            if (!a.get(i).equals(b.get(i))) return a.get(i) - b.get(i);
        }
        return a.size() - b.size();
    }
}