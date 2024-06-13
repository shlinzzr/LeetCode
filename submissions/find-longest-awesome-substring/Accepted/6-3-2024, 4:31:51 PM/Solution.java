// https://leetcode.com/problems/find-longest-awesome-substring

class Solution {
    public int longestAwesome(String s) {

        int state=0;
        int len = s.length();

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int max= 1;

        for(int i=0; i<len; i++){
            char ch = s.charAt(i);

            state ^= 1<<(ch-'0');

            for(int j=0; j<=9; j++){
                int tmp = state ^ (1<<j);
                if(map.containsKey(tmp)){
                    max = Math.max(max, i-map.get(tmp));
                }
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