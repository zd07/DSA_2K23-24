package DynamicProgramm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * FibonacciSeries
 */
public class FibonacciSeries {

    
    
        public static void main(String[] args) {
            
            try (/* Your class should be named Solution.
                         * Read input as specified in the question.
                         * Print output as specified in the question.
                        */
                        // int a=0;
                        // int b=1;
                        // int c=0;
                        //
            Scanner sc = new Scanner(System.in)) {
                int n=sc.nextInt();
                
                int[] dp=new int[n+1];
                //tabulation
                // dp[0] = 0;
                // dp[1] = 1;
                // for(int i=2;i<=n;i++){
                // 	dp[i] = dp[i-1] + dp[i-2];
                // }
                // System.out.println(dp[n]);
   
   
                //memoization
                if(n==1){
                    System.out.print(1);
                     return;
                }
                Arrays.fill(dp, -1);
                fib(n,dp);
                System.out.println(dp[n]);
            }
    
            
        }
        public static int fib(int n,int[] dp){
            if(n<=1) return n;
            if(dp[n]!=-1){
                return dp[n];
            }
            dp[n] = fib(n-1,dp) + fib(n-2,dp);
            return dp[n];
    
        }
    
    
}