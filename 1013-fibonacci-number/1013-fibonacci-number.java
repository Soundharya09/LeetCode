class Solution {
    public static int fib(int n){
        if(n <= 1) return n;
        return fib(n-1) + fib(n-2);
    }
    public static void main(String[] args){
        int n = 8;
        int ans = fib(8);
        System.out.print(ans);
    }   
}
//     public int fib(int n) {
//         int[] memo = new int[31];
//         if(n <= 1) return n;
//         if(memo[n] != 0) return memo[n];
//         memo[n] = fib(n-1) + fib(n-2);
//         return memo[n];
//     }
