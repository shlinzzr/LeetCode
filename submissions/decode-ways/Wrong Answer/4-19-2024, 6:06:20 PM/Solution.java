// https://leetcode.com/problems/decode-ways

class Solution {

    public int numDecodings(String s) {
        // return dpSol(s);
        return helper(0, s,  new HashMap<>());
    }
    
    private int helper(int i,String s,  HashMap<Integer, Integer> memo){

        if(memo.containsKey(i)) return memo.get(i);
        
        int len = s.length();
        if(i==len) return 1;
        if(s.charAt(i)=='0') return 0;
        if(i==len-1) return 1;

        int res = helper(i+1, s, memo);
        if(Integer.parseInt(s.substring(i, i+1))<=26)
            res += helper(i+2, s, memo);
        
        memo.put(i, res);
        return res;
    }


    private int recur(int i, String str, Map<Integer, Integer> memo) {
        // Have we already seen this substring?
        if (memo.containsKey(i)) return memo.get(i);
        
        // If you reach the end of the string, Return 1 for success.
        if (i == str.length()) return 1;

        // If the string starts with a zero, it can't be decoded
        if (str.charAt(i) == '0')  return 0;

        if (i == str.length() - 1) return 1;

        int ans = recur(i+1, str, memo);
        if (Integer.parseInt(str.substring(i, i+2)) <= 26) {
             ans += recur(i+2, str, memo);
         }

        // Save for memoization
        memo.put(i, ans);

        return ans;
    }


    private int dpSol(String s){
        if(s == null || s.length() == 0) 
            return 0;
        int n = s.length();
        int[] dp = new int[n];
        dp[0] = s.charAt(0) != '0' ? 1 : 0;
        for(int i = 1; i < n; i++) {
            int oneDigit = (int) (s.charAt(i)-'0');
            if(oneDigit >= 1 && oneDigit <= 9) {
                dp[i] += dp[i-1];
            }

            int twoDigit = Integer.valueOf(s.substring(i-1, i+1));
            if(twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += i >=2 ? dp[i-2] : 1;
            }
        }
        return dp[n-1];

    }
}