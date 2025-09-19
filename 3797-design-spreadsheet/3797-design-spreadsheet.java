class Spreadsheet {
    private int rows;
    private HashMap<String, Integer> cells;

    public Spreadsheet(int rows) {
        this.rows = rows;
        this.cells = new HashMap<>();
    }
    public void setCell(String cell, int value) {
        cells.put(cell, value);
    }
    public void resetCell(String cell) {
        cells.put(cell, 0);
    }
    public int getValue(String formula) {
        String[] parts = formula.substring(1).split("\\+");
        int sum = 0;

        for (String part : parts) {
            if (isCellReference(part)) {
                sum += cells.getOrDefault(part, 0);
            } 
            else {
                sum += Integer.parseInt(part);
            }
        }
        return sum;
    }
    private boolean isCellReference(String s) {
        if (s == null || s.length() < 2) return false;
        char col = s.charAt(0);
        if (col < 'A' || col > 'Z') return false;

        try {
            int row = Integer.parseInt(s.substring(1));
            return row >= 1 && row <= rows;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
}