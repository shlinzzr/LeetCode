// https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int len = s.length();
        
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int st =0;
        for(int ed=0; ed<s.length(); ed++){
            
            char ch = s.charAt(ed);
            map.put(ch , map.getOrDefault(ch,0)+1);
            
            while(map.size()>k){
                char chh = s.charAt(st);
                map.put(chh, map.get(chh)-1);
                if(map.get(chh)==0)
                    map.remove(chh);
                st++;
            }
            
            max = Math.max(max, ed-st+1);
        }
        
        return max;
    }
}