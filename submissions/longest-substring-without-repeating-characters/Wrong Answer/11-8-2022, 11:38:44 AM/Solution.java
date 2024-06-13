// https://leetcode.com/problems/longest-substring-without-repeating-characters

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map=  new HashMap<>();
        
        
        int st =0, max=0;
        
        boolean con = false;
        
        for(int i=0; i<s.length(); i++){
            
            max = Math.max(max, i-st);
            
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), i);
                
                               
            }else{
                con = true;
                // max = Math.max(max, i-map.get(s.charAt(i)));
                st = map.get(s.charAt(i))+1;
                map.put(s.charAt(i), i);
            }
            
            
        }
        
        if(con==false)
            return s.length();
        
        max= Math.max(max, s.length()-st);
        return max;
    }
}