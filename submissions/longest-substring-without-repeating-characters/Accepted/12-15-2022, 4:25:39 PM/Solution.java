// https://leetcode.com/problems/longest-substring-without-repeating-characters

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        int st =0;
        for(int ed=0; ed<s.length(); ed++){
            
            char ch = s.charAt(ed);
            while(set.contains(ch)){
                set.remove(s.charAt(st));
                st++;
            }
            
            set.add(ch);
            
            max = Math.max(max, ed-st+1);
        }
        
        return max;
    }
}