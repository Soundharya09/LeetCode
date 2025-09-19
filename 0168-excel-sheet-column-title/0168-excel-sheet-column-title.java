class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();
        while(columnNumber > 0) {
            columnNumber--;
            int rem = columnNumber % 26;
            res.insert(0, (char) ('A' + rem));
            columnNumber /= 26;
        }
        return res.toString();
    }
}