// https://leetcode.com/problems/substrings-that-begin-and-end-with-the-same-letter

class Solution {
    public long numberOfSubstrings(String s) {

        int len = s.length();

        Map<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        long res = 0L;
        for(char key : map.keySet()){
            int cnt = map.get(key);
            // [x x x x x i x x x ]
            //  0 1 2 3 4 5 6 7 8,  cnt = 9, right = 9-5

            // abcba
            // [0 1]
            //  1
                // i==0 : res+=2
            //     // i==1
            // for(int i=0; i<cnt; i++){
            //     // int left = i+1;
            //     int left = 1;
            //     int right = cnt-i;
            //     res+= left * right;
            // }

            res = (res+ cnt*(cnt+1)/2);
        }

        return res;

        
    }
}