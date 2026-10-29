class Solution {
    int n;
    int[] parent, depth, heavy, head, pos, size, bit;

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        this.n = n;
        parent = new int[n];
        depth = new int[n];
        heavy = new int[n];
        head = new int[n];
        pos = new int[n];
        size = new int[n];
        bit = new int[n + 1];

        int[] first = new int[n];
        Arrays.fill(first, -1);
        int[] nxt = new int[2 * Math.max(1, n - 1)];
        int[] to = new int[2 * Math.max(1, n - 1)];
        int cnt = 0;
        for (int[] e : edges) {
            to[cnt] = e[1]; nxt[cnt] = first[e[0]]; first[e[0]] = cnt++;
            to[cnt] = e[0]; nxt[cnt] = first[e[1]]; first[e[1]] = cnt++;
        }
        int[] order = new int[n];
        int qh = 0, qt = 0;
        order[qt++] = 0;
        parent[0] = -1;
        while (qh < qt) {
            int u = order[qh++];
            for (int e = first[u]; e != -1; e = nxt[e]) {
                int v = to[e];
                if (v == parent[u]) continue;
                parent[v] = u;
                depth[v] = depth[u] + 1;
                order[qt++] = v;
            }
        }
        Arrays.fill(heavy, -1);
        for (int i = n - 1; i >= 0; i--) {
            int u = order[i];
            size[u] += 1;
            int p = parent[u];
            if (p != -1) {
                size[p] += size[u];
                if (heavy[p] == -1 || size[u] > size[heavy[p]]) heavy[p] = u;
            }
        }
        int cur = 0;
        for (int i = 0; i < n; i++) {
            int u = order[i];
            if (parent[u] == -1 || heavy[parent[u]] != u) {
                for (int v = u; v != -1; v = heavy[v]) {
                    head[v] = u;
                    pos[v] = cur++;
                }
            }
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i++) {
            bitUpdate(pos[i], 1 << (chars[i] - 'a'));
        }
        List<Boolean> res = new ArrayList<>();
        for (String q : queries) {
            String[] parts = q.split(" ");
            if (parts[0].equals("update")) {
                int u = Integer.parseInt(parts[1]);
                char c = parts[2].charAt(0);
                if (chars[u] != c) {
                    int diff = (1 << (chars[u] - 'a')) ^ (1 << (c - 'a'));
                    bitUpdate(pos[u], diff);
                    chars[u] = c;
                }
            } 
            else {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);
                int mask = pathXor(u, v);
                res.add((mask & (mask - 1)) == 0);
            }
        }
        return res;
    }

    private int pathXor(int u, int v) {
        int res = 0;
        while (head[u] != head[v]) {
            if (depth[head[u]] < depth[head[v]]) {
                int t = u; 
                u = v; 
                v = t;
            }
            res ^= rangeXor(pos[head[u]], pos[u]);
            u = parent[head[u]];
        }
        if (depth[u] > depth[v]) {
            int t = u; 
            u = v; 
            v = t;
        }
        res ^= rangeXor(pos[u], pos[v]);
        return res;
    }

    private void bitUpdate(int i, int val) {
        for (i++; i <= n; i += i & -i) bit[i] ^= val;
    }

    private int prefix(int i) {
        int res = 0;
        for (i++; i > 0; i -= i & -i) res ^= bit[i];
        return res;
    }

    private int rangeXor(int l, int r) {
        return prefix(r) ^ prefix(l - 1);
    }
}