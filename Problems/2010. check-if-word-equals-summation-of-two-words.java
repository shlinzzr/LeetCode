// https://leetcode.com/problems/check-if-word-equals-summation-of-two-words

class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        
        int a=0;
        for(char c : firstWord.toCharArray()){
            a = a*10 + c-'a';    
        }
        
        
        int b=0;
        for(char c : secondWord.toCharArray()){
            b = b*10 + c-'a';
        }
        
        
        int c=0;
        for(char ch : targetWord.toCharArray()){
            c = c*10 + ch-'a';
        }
        
        // System.out.println(a);
        // System.out.println(b);
        // System.out.println(c);
        
        return a+b==c;
        
    }
}