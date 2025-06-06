class Solution {
    public List<Integer> getRow(int rowIndex) {
       List<Integer> row = new ArrayList<>();
       row.add(1);
       for(int i = 0; i < rowIndex; i++){
        long nextVal = (long)row.get(i) * (rowIndex - i) / (i + 1);
        row.add((int) nextVal);
       }
       return row; 
    }
}