// https://leetcode.com/problems/longest-substring-without-repeating-characters

class Solution {
    public int lengthOfLongestSubstring(String s) {

        int max = 0;
        
        if(s.length()<=1)
            return s.length();
        
       HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i=0, j=0; i<s.length();i++){
            char c = s.charAt(i);
            
            if(map.containsKey(c)){
                j = map.get(c)+1;
            }
            
            map.put(c, i);
            
            max = Math.max(max, i-j+1);
        }
        
        return max;
        
    }
}