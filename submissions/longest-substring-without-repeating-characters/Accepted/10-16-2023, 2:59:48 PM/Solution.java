// https://leetcode.com/problems/longest-substring-without-repeating-characters

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int len = s.length();

        Set<Character> set =new HashSet<>();

        int st=0;
        for(int ed=0; ed<len; ed++){
            char ch = s.charAt(ed);

            while(st<len && set.contains(ch)){
                set.remove(s.charAt(st++));
            }

            set.add(ch);
            res = Math.max(res, ed-st+1);
        }

        return res;
    }
}