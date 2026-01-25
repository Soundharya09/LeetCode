class StreamChecker {
    private class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;
        
        TrieNode() {
            children = new TrieNode[26];
            isEndOfWord = false;
        }
    }
    private TrieNode root;
    private StringBuilder stream;
    private int maxWordLength;

    public StreamChecker(String[] words) {
        root = new TrieNode();
        stream = new StringBuilder();
        maxWordLength = 0;
        
        for (String word : words) {
            insert(word);
            maxWordLength = Math.max(maxWordLength, word.length());
        }
    }

    private void insert(String word) {
        TrieNode node = root;
        for (int i = word.length() - 1; i >= 0; i--) {
            char ch = word.charAt(i);
            int idx = ch - 'a';
            if (node.children[idx] == null) node.children[idx] = new TrieNode();
            node = node.children[idx];
        }
        node.isEndOfWord = true;
    }
    
    public boolean query(char letter) {
        stream.append(letter);
        if (stream.length() > maxWordLength) stream.deleteCharAt(0);
        TrieNode node = root;
        for (int i = stream.length() - 1; i >= 0; i--) {
            char ch = stream.charAt(i);
            int idx = ch - 'a';
            if (node.children[idx] == null) return false;
            node = node.children[idx];
            if (node.isEndOfWord) return true;
        }
        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */