// https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts

class Solution {
    public int findTheLongestSubstring(String s) {
        String vows = "aeiou";
        int len = s.length();
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, -1);
        int max= 0;

        long state = 0L;
        for(int i=0; i<len; i++){

            char ch = s.charAt(i);

            int idx = vows.indexOf(ch);
            if(idx>=0){
                state ^= 1<<idx;
            }

            if(map.containsKey(state)){
                max = Math.max(max, i-map.get(state));
            }else{
                map.put(state, i);
            }

        }
        return max;
    }
}