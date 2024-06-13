// https://leetcode.com/problems/decode-ways

class Solution {

    Map<Integer, Integer> memo = new HashMap<>();

    public int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len+1]; // 用到第幾個digit的時候的組合數

        dp[0] = 1; 
        //這邊補1是指說 如果之後被用上了like dp = dp[i-1]+ "dp[i-2]", 
        //dp[0]此時代表的是s.charAt(0)可以跟s.charAt(1)湊成一個數字<=26, 組合數是1
        dp[1] = s.charAt(0)=='0' ? 0 : 1; //如果第1個digit是'0' 表示完全沒得搞 組合數是０
        for(int i=2; i<=len; i++){ 

            int digtIdx = i-1;  //dp[2] = s.charAt(1) 

            if(s.charAt(digtIdx)=='0') continue; // 目前這位digit==0 當末位是'0'是完全沒得搞

            dp[i] = dp[i-1]; //累積的組合數量從上一輪來
            
            // 檢查一下 dp[2] check prev = s.charAt(0)+s.charAt(1)
            String prev = s.substring(i-2, i);
            int val = Integer.parseInt(prev);
             if(s.charAt(i-2)!='0' && val<=26 && val>0 ){
                dp[i]+= dp[i-2];
            }   
        }

        return dp[len];

        // return recur(0, s);
    }
    
    private int recur(int idx, String str) {
        // Have we already seen this substring?
        if (memo.containsKey(idx)) {
            return memo.get(idx);
        }
        
        // If you reach the end of the string
        // Return 1 for success.
        if (idx == str.length()) {
            return 1;
        }

        // If the string starts with a zero, it can't be decoded
        if (str.charAt(idx) == '0') {
            return 0;
        }

        if (idx == str.length() - 1) {
            return 1;
        }


        int ans = recur(idx + 1, str);
        if (Integer.parseInt(str.substring(idx, idx + 2)) <= 26) {
             ans += recur(idx + 2, str);
         }

        // Save for memoization
        memo.put(idx, ans);

        return ans;
    }
}