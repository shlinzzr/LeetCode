// https://leetcode.com/problems/longest-substring-without-repeating-characters

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int len = s.length();
        
        int max = 0;
        
        HashSet<Character> set = new HashSet<>();
        
        int st=0;
        for(int ed=0; ed<s.length(); ed++){
            char ch = s.charAt(ed);
            
            while(set.contains(ch)){
                set.remove(s.charAt(st++));
            }
            
            max = Math.max(ed-st+1, max);
            
            set.add(ch);
        }
        
        return max;
        
    }
}