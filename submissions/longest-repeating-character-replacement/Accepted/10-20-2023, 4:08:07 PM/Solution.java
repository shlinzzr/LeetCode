// https://leetcode.com/problems/longest-repeating-character-replacement

class Solution {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        HashMap<Character, Integer> map = new HashMap<>();

        int res = 0;
        int max= 0 ;
        int st = 0;
        for(int ed=0; ed<len; ed++){
            char ch = s.charAt(ed);
            map.put(ch, map.getOrDefault(ch,0)+1);
            max = Math.max(max, map.get(ch));

            while(ed-st+1-max>k){
                char chst = s.charAt(st);
                map.put(chst, map.get(chst)-1);
                st++;
            }

            res = Math.max(res, ed-st+1);
        }

        return res;
    }
}