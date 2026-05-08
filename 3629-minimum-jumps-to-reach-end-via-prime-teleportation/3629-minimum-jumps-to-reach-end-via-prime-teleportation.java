class Solution {
    private static final int MX = 1_000_001;
    private static final int[] spf = new int[MX];
    static {
        for (int i = 0; i < MX; i++) spf[i] = i;
        for (int i = 2; (long) i * i < MX; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j < MX; j += i) {
                    if (spf[j] == j) spf[j] = i;
                }
            }
        }
    }

    public int minJumps(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;

        Map<Integer, List<Integer>> bucket = new HashMap<>();
        for (int j = 0; j < n; j++) {
            int x = nums[j];
            while (x > 1) {
                int p = spf[x];
                bucket.computeIfAbsent(p, k -> new ArrayList<>()).add(j);
                while (x % p == 0) x /= p;
            }
        }

        int[] q = new int[n];
        int head = 0, tail = 0;
        boolean[] seen = new boolean[n];
        seen[0] = true;
        q[tail++] = 0;

        int steps = 0;
        while (head < tail) {
            int size = tail - head;
            while (size-- > 0) {
                int i = q[head++];
                if (i == n - 1) return steps;

                if (i > 0 && !seen[i - 1]) {
                    seen[i - 1] = true;
                    q[tail++] = i - 1;
                }
                if (i + 1 < n && !seen[i + 1]) {
                    seen[i + 1] = true;
                    q[tail++] = i + 1;
                }

                int val = nums[i];
                if (val > 1 && spf[val] == val) {
                    List<Integer> targets = bucket.remove(val);
                    if (targets != null) {
                        for (int j : targets) {
                            if (!seen[j]) {
                                seen[j] = true;
                                q[tail++] = j;
                            }
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}