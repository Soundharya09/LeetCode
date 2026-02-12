class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int countZero = 0;
        int countOne = 0;
        for(int student : students) {
            if(student == 0) countZero++;
            else countOne++;
        }
        for(int sandwich : sandwiches) {
            if(sandwich == 0) {
                if(countZero > 0) countZero--;
                else break;
            }
            else {
                if(countOne > 0) countOne--;
                else break;
            }
        }
        return countZero + countOne;
    }
}