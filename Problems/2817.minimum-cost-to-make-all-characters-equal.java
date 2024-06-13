// https://leetcode.com/problems/minimum-cost-to-make-all-characters-equal

class Solution {
    public long minimumCost(String s) {
        
        long res = 0;
        for (int i = 1;  i < s.length(); ++i)
            if (s.charAt(i) != s.charAt(i-1))
                res += Math.min(i, s.length()- i);
        return res;
    }
        
}