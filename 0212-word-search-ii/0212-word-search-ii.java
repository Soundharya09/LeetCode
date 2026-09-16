class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
            }
            node.word = word;
        }
        return root;
    }
    private int rows, cols;
    private char[][] board;
    private List<String> result;

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        this.rows = board.length;
        this.cols = board[0].length;
        this.result = new ArrayList<>();

        TrieNode root = buildTrie(words);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dfs(i, j, root);
            }
        }
        return result;
    }
    private void dfs(int i, int j, TrieNode node) {
        if (i < 0 || i >= rows || j < 0 || j >= cols) return;

        char c = board[i][j];
        if (c == '#' || node.children[c - 'a'] == null) return;

        TrieNode next = node.children[c - 'a'];

        if (next.word != null) {
            result.add(next.word);
            next.word = null;
        }

        board[i][j] = '#';

        dfs(i + 1, j, next);
        dfs(i - 1, j, next);
        dfs(i, j + 1, next);
        dfs(i, j - 1, next);

        board[i][j] = c;

        if (isLeaf(next)) {
            node.children[c - 'a'] = null;
        }
    }

    private boolean isLeaf(TrieNode node) {
        for (TrieNode child : node.children) {
            if (child != null) return false;
        }
        return true;
    }
}