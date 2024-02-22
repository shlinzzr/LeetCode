// https://leetcode.com/problems/reverse-prefix-of-word

class Solution {
    public String reversePrefix(String word, char ch) {
        
        int idx = word.indexOf(ch);
        if(idx>0){
            char[] ca = word.toCharArray();
            
            for(int i=0; i<=idx/2; i++){
                char c = ca[i];
                ca[i] = ca[idx-i];
                ca[idx-i] = c;
            }
            word = String.valueOf(ca);    
            
        }
        
        return word;
            
        
    }
}