class Solution {
    char[] arr;
    int n;
    char[] leftChar, rightChar;
    int[] prefLen, sufLen, maxLen, segLen;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        arr = s.toCharArray();
        n = arr.length;
        int size = 4 * n;
        leftChar = new char[size];
        rightChar = new char[size];
        prefLen = new int[size];
        sufLen = new int[size];
        maxLen = new int[size];
        segLen = new int[size];

        build(1, 0, n - 1);

        int k = queryCharacters.length();
        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            int idx = queryIndices[i];
            char c = queryCharacters.charAt(i);
            arr[idx] = c;
            update(1, 0, n - 1, idx, c);
            result[i] = maxLen[1];
        }
        return result;
    }

    private void build(int node, int l, int r) {
        if (l == r) {
            leftChar[node] = arr[l];
            rightChar[node] = arr[l];
            prefLen[node] = 1;
            sufLen[node] = 1;
            maxLen[node] = 1;
            segLen[node] = 1;
            return;
        }
        int mid = (l + r) / 2;
        int leftNode = 2 * node;
        int rightNode = 2 * node + 1;
        build(leftNode, l, mid);
        build(rightNode, mid + 1, r);
        merge(node, leftNode, rightNode);
    }

    private void update(int node, int l, int r, int idx, char c) {
        if (l == r) {
            leftChar[node] = c;
            rightChar[node] = c;
            prefLen[node] = 1;
            sufLen[node] = 1;
            maxLen[node] = 1;
            segLen[node] = 1;
            return;
        }
        int mid = (l + r) / 2;
        int leftNode = 2 * node;
        int rightNode = 2 * node + 1;
        if (idx <= mid) update(leftNode, l, mid, idx, c);
        else update(rightNode, mid + 1, r, idx, c);
        merge(node, leftNode, rightNode);
    }

    private void merge(int node, int leftNode, int rightNode) {
        segLen[node] = segLen[leftNode] + segLen[rightNode];
        leftChar[node] = leftChar[leftNode];
        rightChar[node] = rightChar[rightNode];

        if (prefLen[leftNode] == segLen[leftNode] && leftChar[leftNode] == leftChar[rightNode]) {
            prefLen[node] = segLen[leftNode] + prefLen[rightNode];
        } 
        else prefLen[node] = prefLen[leftNode];

        if (sufLen[rightNode] == segLen[rightNode] && rightChar[rightNode] == rightChar[leftNode]) {
            sufLen[node] = segLen[rightNode] + sufLen[leftNode];
        } 
        else sufLen[node] = sufLen[rightNode];

        maxLen[node] = Math.max(maxLen[leftNode], maxLen[rightNode]);
        if (rightChar[leftNode] == leftChar[rightNode]) {
            maxLen[node] = Math.max(maxLen[node], sufLen[leftNode] + prefLen[rightNode]);
        }
    }
}