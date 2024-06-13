// https://leetcode.com/problems/count-the-number-of-special-characters-i

class Solution {
    public int numberOfSpecialChars(String word) {
        Set<Character> set = new HashSet<>();
        
        // set.addAll(new HashSet<>(Arrays.asList(word.toCharArray())));
        
        for(char ch : word.toCharArray())
            set.add(ch);
        
        int res= 0 ;
        
        for(int i=0; i<26; i++){
            char cha = (char) ('a'+i);
            char chA =  (char) ('A'+i);
            
            if(set.contains(cha) && set.contains(chA)) res++;
        }
        
        return res;
        
    }
}