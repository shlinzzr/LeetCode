// https://leetcode.com/problems/number-of-wonderful-substrings

class Solution {
    public long wonderfulSubstrings(String word) {

        // abcdefghij => 2^10;

        long state = 0L;

        int len = word.length();

        Map<Long, Long> map = new HashMap<>(); // state , cnt
        map.put(0L, 1L);
        long ans = 0L;

        for(int i=0; i<len; i++){
            char ch = word.charAt(i);
            state ^= 1<<(ch-'a');

            for(int d=0; d<10; d++){
                long next = state ^ (1<<d);
                if(map.containsKey(next)){
                    ans += map.get(next);
                }
            }
            ans += map.getOrDefault(state, 0L);

            map.put(state, map.getOrDefault(state, 0L) +1);

        }

        return ans;

        
    }
}