// https://leetcode.com/problems/find-longest-awesome-substring

class Solution {
    public int longestAwesome(String s) {

        int len = s.length();

        Map<Long, Integer> map = new HashMap<>(); //state, idx
        map.put(0L, -1);

        long state = 0L;
        int max = 0;

        for(int i=0; i<len; i++){

            char ch = s.charAt(i);
            int idx = ch-'0';

            state ^= (1<<idx); 

            // with one filp
            for(long d=0; d<10; d++){
                long code = state^(1<<d);

                if(map.containsKey(code)){
                    max = Math.max(max, i-map.get(code));
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

    private boolean isSwapPal(String s){
        
        Map<Character, Integer> map = new HashMap<>();

        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }

        int odd = 0;
        for(int val : map.values()){
            if(val%2==0)
                continue;
            else 
                odd++;
        }

        return odd<=1;
    }
}