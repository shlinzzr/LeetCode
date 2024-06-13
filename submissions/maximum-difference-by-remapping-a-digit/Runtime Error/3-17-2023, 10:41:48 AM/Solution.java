// https://leetcode.com/problems/maximum-difference-by-remapping-a-digit

class Solution {
    public int minMaxDifference(int num) {
        String s = String.valueOf(num);
        char ch = s.charAt(0);
        
        int i=0;
        while(i<s.length() && ch=='9'){
            i++;
            ch=s.charAt(i);
        }
        String maxStr = s.replaceAll(ch+"", "9");
        
                
        i=0;
        ch=s.charAt(i);
        while(i<s.length() && ch=='0'){
            i++;
            ch=s.charAt(i);
        }
        String minStr = s.replaceAll(ch+"", "0");
        // System.out.println(maxStr);
        // System.out.println(minStr);
        int max = Integer.valueOf(maxStr);
        int min = Integer.valueOf(minStr);
        
        return max-min;
    }
}