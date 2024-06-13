// https://leetcode.com/problems/find-longest-awesome-substring

class Solution {
    public int longestAwesome(String s) {

        int len = s.length();

        int state = 0;

        Map<Integer, Integer> map = new HashMap<>(); // state, idx
        map.put(0, -1);
        int max = 0;


        for(int i=0; i<len; i++){
            char ch = s.charAt(i);
            state ^= 1<<(ch-'0');

            if(map.containsKey(state)){
                    max = Math.max(max, i-map.get(state));
            }

            for(int j=0; j<10; j++){
                int v = state^(1<<j);

                if(map.containsKey(v)){
                    max = Math.max(max, i-map.get(v));
                }
            }

            
        }        

        return max;
    }
}