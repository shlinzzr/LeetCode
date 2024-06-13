// https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts

class Solution {
    public int findTheLongestSubstring(String s) {

        int len = s.length();
        Map<Long, Long> map = new HashMap<>();
        map.put(0L, 1L);
        long state = 0L; // aeiou
        long res = 0L;

        char[] arr = new char[]{'a','e','i','o','u'};
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('a');
        
        for(int i=0; i<len; i++){
            char ch = s.charAt(i);
            int idx = ch-'a';



        }


        
    }
}