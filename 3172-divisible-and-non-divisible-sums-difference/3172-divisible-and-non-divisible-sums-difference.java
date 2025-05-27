class Solution {
    public int differenceOfSums(int n, int m) {
        int nonDivSum = 0, divSum = 0;
        for(int i=1; i<=n; i++){
            if(i % m != 0) nonDivSum += i;
            if(i % m == 0) divSum += i; 
        }
        return nonDivSum - divSum;
    }
}