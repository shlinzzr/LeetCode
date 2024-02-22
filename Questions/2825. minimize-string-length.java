// https://leetcode.com/problems/minimize-string-length

class Solution {
    public int minimizedStringLength(String s) {
        Set<Character> set = new HashSet<>();
        
        for(char ch : s.toCharArray()){
            set.add(ch);
        }
        
        return set.size();
        
    }
}