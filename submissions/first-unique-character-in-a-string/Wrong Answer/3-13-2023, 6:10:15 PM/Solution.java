// https://leetcode.com/problems/first-unique-character-in-a-string

class Solution {
    public int firstUniqChar(String s) {
        HashSet<Character> set = new HashSet<>();
        
        int len = s.length();
        boolean[] dul = new boolean[len];
        for(int i=0; i<len ;i++){
            char ch = s.charAt(i);
            if(set.add(ch)==false)
                dul[i]=true;
        }
        
        for(int i=0; i<len; i++){
            if(dul[i]==false)
                return i;
        }
        return -1;
    }
}