// https://leetcode.com/problems/number-of-wonderful-substrings

class Solution {
    public long wonderfulSubstrings(String word) {

        int oddCnt;


        // word : consist of 'a'~'j'
        // return  # of wonderful substring

        int len = word.length();

        long state = 0; 
        //  abcdefghij
        //k 0123456789
        //  0100010100

        long res = 0L;

        // int[] arr = new int[1<<10]; // 'a'~'j'
        // using arr to record history of state
        // maybe using map will be lot smaller

        HashMap<Long, Long> map = new HashMap<>();
        map.put(0L, 1L); //init 組成state==0的排列方式為1種

        for(int i=0; i<len; i++){
            char ch = word.charAt(i);
            int idx = ch-'a';
            state ^= (1<<idx);

            res += map.getOrDefault(state, 0L); // with all letters are even

            for(int k=0; k<10; k++){
                res += map.getOrDefault(state^(1<<k), 0L); // with 'a'~'j' filp one char
            }

            map.put(state, map.getOrDefault(state,0L)+1);
        }

        return res;
        
    }
}