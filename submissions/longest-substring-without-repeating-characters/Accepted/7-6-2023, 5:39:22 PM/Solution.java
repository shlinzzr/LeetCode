// https://leetcode.com/problems/longest-substring-without-repeating-characters

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        
        int len = s.length();
        
        HashSet<Character> set =new HashSet<>();
        
        
        int left = 0;
        for(int right=0; right<len; right++){
            
            char ch = s.charAt(right);
            
                
            while(left<right && set.contains(ch)){
                char chh = s.charAt(left);
                set.remove(chh);
                left++;
            }
            
            max = Math.max(max, right-left+1);
            set.add(ch);
        }
        
        return max;
    }
}