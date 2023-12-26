package LeetCode75;

public class DecodeWays {
    public int numDecodings(String s) {
        //     if(s == null || s.length() == 0){
        //         return 0;
        //     }
        //     Map<String, Character> map = new HashMap<>();
        //     for(int i = 1; i <= 26; i++){
        //         char c = (char) ((int)'A' + (i - 1));
        //         map.put(String.valueOf(i), c);
        //     }
        //     return helper(s, 0, 0, map);
        // }
        // private int helper(String s, int result, int start, Map<String, Character> map){
        //     if(start >= s.length()){
        //         return result + 1;
        //     }
        //     if(start + 1 <= s.length() && map.containsKey(s.substring(start, start + 1))){
        //         result = helper(s, result, start + 1, map);
        //     }
        //     if(start + 2 <= s.length() && map.containsKey(s.substring(start, start + 2))){
        //         result = helper(s, result, start + 2, map);
        //     }
        //     return result;
            int n = s.length();
            int[] dp = new int[n+1];
            dp[0] = 1;
    
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) != '0') {
                    dp[i+1] = dp[i];
                }
    
                if (i > 0 && (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6'))) {
                    dp[i+1] += dp[i-1];
                }
            }
            return dp[n];
        }
}
