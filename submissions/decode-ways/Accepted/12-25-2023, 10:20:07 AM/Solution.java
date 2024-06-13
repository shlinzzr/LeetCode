// https://leetcode.com/problems/decode-ways

class Solution {

    Map<Integer, Integer> memo = new HashMap<>();

    public int numDecodings(String s) {
        return helper(0, s);
    }
    
    private int helper(int idx, String str) {
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


        int ans = helper(idx + 1, str);
        if (Integer.parseInt(str.substring(idx, idx + 2)) <= 26) {
             ans += helper(idx + 2, str);
         }

        // Save for memoization
        memo.put(idx, ans);

        return ans;
    }
}