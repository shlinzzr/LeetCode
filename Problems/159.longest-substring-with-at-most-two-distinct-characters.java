// https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int max = 0;
        
        int st = 0;
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(int ed=0; ed<s.length(); ed++){
            map.put(s.charAt(ed), map.getOrDefault(s.charAt(ed),0)+1);
            
            while(map.size()>2){
                map.put(s.charAt(st), map.get(s.charAt(st))-1);
                if(map.get(s.charAt(st))==0){
                    map.remove(s.charAt(st));
                }
                st++;
            }
            
            max = Math.max(max, ed-st+1);
        }
        
        return max;
        
    }
}