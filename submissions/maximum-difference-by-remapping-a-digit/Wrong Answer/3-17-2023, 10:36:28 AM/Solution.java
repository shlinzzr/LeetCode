// https://leetcode.com/problems/maximum-difference-by-remapping-a-digit

class Solution {
    public int minMaxDifference(int num) {
        String s = String.valueOf(num);
        char ch = s.charAt(0);
        String maxStr = s.replaceAll(ch+"", "9");
        String minStr = s.replaceAll(ch+"", "0");
        
        int max = Integer.valueOf(maxStr);
        int min = Integer.valueOf(minStr);
        
        return max-min;
    }
}