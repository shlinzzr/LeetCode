// https://leetcode.com/problems/maximum-difference-by-remapping-a-digit

class Solution {
    public int minMaxDifference(int num) {
        String s = String.valueOf(num);
        
        int i=0;
        while(i<s.length()-1 && s.charAt(i)=='9'){
            i++;
        }
        String maxStr = s.replaceAll(s.charAt(i)+"", "9");
        
                
        i=0;
        while(i<s.length()-1 && s.charAt(i)=='0'){
            i++;
        }
        
        String minStr = s.replaceAll(s.charAt(i)+"", "0");
        // System.out.println(maxStr);
        // System.out.println(minStr);
        int max = Integer.valueOf(maxStr);
        int min = Integer.valueOf(minStr);
        
        return max-min;
    }
}