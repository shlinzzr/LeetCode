// https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int len = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;

        int st=0;
        for(int ed=0; ed<len; ed++){
            char ch = s.charAt(ed);
            map.put(ch, map.getOrDefault(ch, 0)+1);
            
            while(map.size()>2){
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