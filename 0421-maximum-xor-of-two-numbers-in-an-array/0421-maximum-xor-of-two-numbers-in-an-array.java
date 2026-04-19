class Solution {
    private static class TrieNode {
        TrieNode[] children = new TrieNode[2];
    }
    private TrieNode root;
    public void insert(int num) {
        TrieNode curr = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (curr.children[bit] == null) curr.children[bit] = new TrieNode();
            curr = curr.children[bit];
        }
    }
    public int findMaxXOR(int num) {
        TrieNode curr = root;
        int maxXOR = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int opposite = 1 - bit;         
            if (curr.children[opposite] != null) {
                maxXOR |= (1 << i);        
                curr = curr.children[opposite];
            } 
            else curr = curr.children[bit]; 
        }
        return maxXOR;
    }
    public int findMaximumXOR(int[] nums) {
        root = new TrieNode();
        for (int num : nums) {
            insert(num);
        }
        int result = 0;
        for (int num : nums) {
            result = Math.max(result, findMaxXOR(num));
        }
        return result;
    }
}