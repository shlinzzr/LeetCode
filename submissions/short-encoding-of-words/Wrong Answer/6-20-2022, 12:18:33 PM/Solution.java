// https://leetcode.com/problems/short-encoding-of-words

class Solution {
    public int minimumLengthEncoding(String[] words) {
        int[] indices = new int [words.length];
        String encodedStr = "";
        
        for(int i=0; i<words.length; i++){

            if(encodedStr.endsWith(words[i] + "#")){

                indices[i] = encodedStr.indexOf(words[i]);
                    
            }else{
                encodedStr += words[i] + "#";
                indices[i] = encodedStr.lastIndexOf(words[i]);
            }
        }
        
        return encodedStr.length();
        
    }
}