// https://leetcode.com/problems/longest-substring-without-repeating-characters

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int max = 0;
        for(int i=0; i<s.length(); i++){
            
            HashSet<Character> set = new HashSet<>();
            
            for(int j=i; j<s.length(); j++){
                
                if(set.contains(s.charAt(j))){
                    break;
                }
                
                set.add(s.charAt(j));
                
            }
            
            if(set.size()>max)
                max = set.size();
            
            
        }
        
        return max;
    }
}