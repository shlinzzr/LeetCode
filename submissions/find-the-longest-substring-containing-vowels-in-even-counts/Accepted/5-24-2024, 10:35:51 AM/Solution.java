// https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts

class Solution {
    public int findTheLongestSubstring(String s) {
        int len = s.length();

        Set<Character> vowels= new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        int max = 0;
        int state = 0;

        Map<Integer, Integer> map = new HashMap<>();// state, idx
        map.put(0, -1);

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(vowels.contains(ch)){
                state ^= 1<<(ch-'a');
            }

            if(map.containsKey(state))
                max = Math.max(max, i-map.get(state));
            else
                map.put(state, i);

        }
        

        return max;
    }
}