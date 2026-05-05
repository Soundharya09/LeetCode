class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> rowMap = new HashMap<>();
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            if (col >= 2 && col <= 9) rowMap.merge(row, 1 << (col - 2), (a, b) -> a | b);
        }
        final int LEFT   = 0x0F;   
        final int MIDDLE = 0x3C;   
        final int RIGHT  = 0xF0; 

        int result = 0;
        for (Map.Entry<Integer, Integer> entry : rowMap.entrySet()) {
            int mask = entry.getValue();            
            int groups = 0;
            if ((mask & LEFT) == 0) {
                groups++;
                mask |= LEFT;                       
            }
            if ((mask & RIGHT) == 0) groups++;
            if (groups == 0 && (mask & MIDDLE) == 0) groups++;
            result += groups;
        }
        int emptyRows = n - rowMap.size();
        result += emptyRows * 2;
        return result;
    }
}