class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length, n = boxGrid[0].length;
        char[][] res = new char[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                res[i][j] = boxGrid[j][i];
            }
        }
        for(int i = 0; i < n; i++) {
            reverse(res[i]);
        }
        for (int j = 0; j < m; j++) {
            for (int i = n - 1; i >= 0; i--) {
                if (res[i][j] == '.') {
                    int nextRowWithStone = -1;
                    for (int k = i - 1; k >= 0; k--) {
                        if (res[k][j] == '*') break;
                        if (res[k][j] == '#') {
                            nextRowWithStone = k;
                            break;
                        }
                    }
                    if (nextRowWithStone != -1) {
                        res[nextRowWithStone][j] = '.';
                        res[i][j] = '#';
                    }
                }
            }
        }
        return res;
    }
    public void reverse(char[] row) {
        int left = 0;
        int right = row.length - 1;
        while (left < right) {
            char temp = row[left];
            row[left] = row[right];
            row[right] = temp;
            left++;
            right--;
        }
    }
}