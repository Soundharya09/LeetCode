class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1 || numRows > s.length()) return s;
        StringBuilder[] rows = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        int currRow = 0;
        boolean down = true;
        for(char c : s.toCharArray()) {
            rows[currRow].append(c);
            if (down) currRow++;
            else currRow--;
            if (currRow == numRows - 1) down = false;
            else if (currRow == 0) down = true;
        }
        StringBuilder res = new StringBuilder();                    
        for(StringBuilder row : rows) {
            res.append(row);                                       
        }
        return res.toString();
    }
}