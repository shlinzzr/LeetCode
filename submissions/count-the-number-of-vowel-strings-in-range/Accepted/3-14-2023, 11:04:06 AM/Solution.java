// https://leetcode.com/problems/count-the-number-of-vowel-strings-in-range

class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        
        int cnt = 0;
        for(int i=left; i<=right; i++){
            
            String w  = words[i];
            int len = w.length();
            if(set.contains(w.charAt(0)) && set.contains(w.charAt(len-1)))
                cnt++;
            
        }
        
        return cnt;
    }
}