// https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping

class Solution {
    public String freqAlphabets(String s) {
        
        String[] arr = new String[26];
        for(int i=0; i<26; i++){
            if(i<9)
                arr[i] = (i+1) + "";
            else{
                arr[i] = (i+1) + "#";
            }
        }
        
        
        for(int i=25; i>=0; i--){
           s= s.replaceAll(arr[i], ((char)(i+'a'))+"");
        }
        
        return s;
        
        
        
    }
}