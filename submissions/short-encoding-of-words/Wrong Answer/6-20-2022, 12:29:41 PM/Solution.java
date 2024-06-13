// https://leetcode.com/problems/short-encoding-of-words

class Solution {
    public int minimumLengthEncoding(String[] words) {
        int[] indices = new int [words.length];
        String encodedStr = "";
        
        for(int i=0; i<words.length; i++){

            String word = words[i]+"#";
            
            if(encodedStr.endsWith(word)){   // "me#".endswith("time#") == false

                indices[i] = encodedStr.indexOf(words[i]);
                    
            }else if( word.endsWith(encodedStr) ){ // "time#".endswith("me#")
               
                int offset = word.indexOf(encodedStr);
                for(int j=0; j<i; j++){
                    indices[j] += offset;
                }
                indices[i] = 0;
                encodedStr = word;
                
                
                
            }else{
                encodedStr += words[i] + "#";
                indices[i] = encodedStr.lastIndexOf(words[i]);
            }
        }
        
        return encodedStr.length();
        
        
        // time#
        // [2, 0]
    }
}