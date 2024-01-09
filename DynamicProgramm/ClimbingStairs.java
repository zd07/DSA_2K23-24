package DynamicProgramm;

public class ClimbingStairs {
    public int climbStairs(int n) {
        // recursive
        // if (n == 0 || n == 1) {
        // return 1;
        // }
        // return climbStairs(n-1) + climbStairs(n-2);
        // tabulation
        if (n == 0 || n == 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
        // memoizaton
        // int ways[]=new int[n+1];
        // Arrays.fill(ways,-1);
        // return countways(n,ways);
        // }
        // public static int countways(int n,int ways[]){
        // if(n==0) return 1;
        // if(n<0) return 0;
        // if(ways[n]!=-1){
        // return ways[n];
        // }
        // ways[n] =countways(n-1,ways)+countways(n-2,ways);
        // return ways[n];
    }
}
