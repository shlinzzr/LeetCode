// https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        
        int len = s.length();
        
        Map<Character, Integer>map = new HashMap<>();
        int max = 0;
        int st = 0;
        for(int ed=0; ed<len; ed++){
            map.put(s.charAt(ed), map.getOrDefault(s.charAt(ed),0)+1);
            
            while(map.size()>k){
                map.put(s.charAt(st), map.get(s.charAt(st))-1);
                if(map.get(s.charAt(st))==0)
                    map.remove(s.charAt(st));
                st++;
            }
            
            max = Math.max(max, ed-st+1);
        }
        
        return max;
        
    }
}