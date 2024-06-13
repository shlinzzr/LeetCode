// https://leetcode.com/problems/decode-ways

class Solution {

    public int numDecodings(String s) {
        // return dpSol(s);
        int len = s.length();

        return helper( s, 0, new HashMap<>());
    }
    
    private int helper( String s, int idx, HashMap<Integer,Integer> memo){
       
      if(memo.containsKey(idx)) return memo.get(idx);
    
      if(idx>= s.length()) return 1;
    
       int len = s.length();
       
       int res = 0;
       char ch1 = s.charAt(idx);
       if(ch1=='0') return 0;
    /*
       int res = helper(s, idx+1, memo);
       if(idx+2 <= s.length() && Integer.parseInt(s.substring(idx, idx+2))<=26)
          res += helper(s, idx+2, memo);
    
    
    */
       else if(ch1=='2'){
         
           res += helper(s, idx+1, memo);
           if(idx+1 < s.length()){
             
                char ch2 = s.charAt(idx+1);
             
                if(ch2>='0' && ch2<='6'){
                     res+= helper(s, idx+2, memo);
                }
           }
       }else{ // ch=='1'
            res+= helper(s, idx+1, memo);
            if(idx+1 < s.length() && ch1<'3'){
                 res+= helper(s, idx+2, memo);
            }
       }
    
    //   memo.put(idx, res);
    
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