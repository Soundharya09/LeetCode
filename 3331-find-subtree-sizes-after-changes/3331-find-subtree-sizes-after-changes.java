class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        int[] head = new int[n];
        int[] next = new int[n];
        Arrays.fill(head, -1);
        for (int i = 1; i < n; i++) {
            next[i] = head[parent[i]];
            head[parent[i]] = i;
        }
        int[] newParent = new int[n];
        newParent[0] = -1;
        int[] last = new int[26];
        Arrays.fill(last, -1);
        int[] stack = new int[n];
        int[] iter = new int[n];     
        int[] saved = new int[n];  
        int sp = 0;

        stack[sp++] = 0;
        iter[0] = head[0];
        saved[0] = last[s.charAt(0) - 'a'];
        last[s.charAt(0) - 'a'] = 0;

        while (sp > 0) {
            int u = stack[sp - 1];
            int child = iter[u];
            if (child != -1) {
                iter[u] = next[child];
                int c = s.charAt(child) - 'a';
                newParent[child] = (last[c] != -1) ? last[c] : parent[child];
                saved[child] = last[c];
                last[c] = child;
                iter[child] = head[child];
                stack[sp++] = child;
            } 
            else {
                last[s.charAt(u) - 'a'] = saved[u];
                sp--;
            }
        }
        int[] nHead = new int[n];
        int[] nNext = new int[n];
        Arrays.fill(nHead, -1);
        for (int i = 1; i < n; i++) {
            nNext[i] = nHead[newParent[i]];
            nHead[newParent[i]] = i;
        }
        int[] order = new int[n];
        int front = 0, back = 0;
        order[back++] = 0;
        while (front < back) {
            int u = order[front++];
            for (int c = nHead[u]; c != -1; c = nNext[c]) {
                order[back++] = c;
            }
        }
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        for (int i = n - 1; i > 0; i--) {
            int u = order[i];
            ans[newParent[u]] += ans[u];
        }
        return ans;
    }
}