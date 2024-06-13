// https://leetcode.com/problems/string-compression-iii

class Solution {
    public String compressedString(String word) {
//         Begin with an empty string comp. While word is not empty, use the following operation:
// Remove a maximum length prefix of word made of a single character c repeating at most 9 times.
// Append the length of the prefix followed by c to comp.
// Return the string comp.
        
        
        StringBuilder comp = new StringBuilder();
        char[] arr = word.toCharArray();
        
        int len = word.length();
        for(int i=0; i<len ;i++){
                
            int j=1;
            for( ; j<9; j++){
                if(i+j>=len || arr[i]!=arr[i+j]) break;
            }
            comp.append(j).append(arr[i]);
            i+=j-1;
            
        }
        
        return comp.toString();
    }
}