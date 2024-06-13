// https://leetcode.com/problems/longest-repeating-character-replacement

class Solution {
    public int characterReplacement(String s, int k) {

        int len = s.length();

        Map<Character, Integer> map = new HashMap<>();

        int max = 0;
        int res = 0;
        int st = 0;
        for(int i=0; i<len; i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);

           
            for(int cnt : map.values()){
                max = Math.max(max, cnt);
            }

            int wLen = i-st+1;
            while(st<i && wLen-max>k){
                char chh = s.charAt(st);
                map.put(chh, map.get(chh)-1);
                st++;
            }

            res = Math.max(res, i-st+1);


        }

        return res;
        
    }
}