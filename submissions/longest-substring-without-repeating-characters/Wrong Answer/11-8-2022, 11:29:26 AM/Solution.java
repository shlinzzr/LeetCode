// https://leetcode.com/problems/longest-substring-without-repeating-characters

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map=  new HashMap<>();
        
        
        int st =0, max=0;
        
        for(int i=0; i<s.length(); i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), i);
            }else{
                max = Math.max(max, i-map.get(s.charAt(i)));
                st = map.get(s.charAt(i))+1;
                map.put(s.charAt(i), i);
            }
        }
        
        
        
        for(Map.Entry<Character, Integer> en : map.entrySet()){
            st = Math.max(st, en.getValue());
        }
        
        max= Math.max(max, s.length()-st);
        return max;
    }
}