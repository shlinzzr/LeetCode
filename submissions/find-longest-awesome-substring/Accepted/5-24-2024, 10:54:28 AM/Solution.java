// https://leetcode.com/problems/find-longest-awesome-substring

class Solution {
    public int longestAwesome(String s) {

        int len = s.length();

        long state = 0;

        Map<Long, Integer> map = new HashMap<>(); // state, idx
        map.put(0L, -1);
        int max = 0;


        for(int i=0; i<len; i++){
            char ch = s.charAt(i);
            state ^= 1<<(ch-'0');

           

            for(int j=0; j<10; j++){
                long v = state^(1<<j);

                if(map.containsKey(v)){
                    max = Math.max(max, i-map.get(v));
                }
            }
            
            if(map.containsKey(state)){
                max = Math.max(max, i-map.get(state));
            }else
                map.put(state, i);

            
        }        

        return max;
    }
}