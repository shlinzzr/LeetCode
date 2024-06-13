// https://leetcode.com/problems/short-encoding-of-words

class Solution {
    public int minimumLengthEncoding(String[] words) {
        int[] indices = new int [words.length];
        String encodedStr = "";
        
        for(int i=0; i<words.length; i++){

            String word = words[i]+"#";
            
            if(encodedStr.endsWith(word)){   // "p#"

                indices[i] = encodedStr.indexOf(words[i]);
                    
            }else if( !encodedStr.isEmpty() && word.endsWith(encodedStr.substring(0, encodedStr.indexOf("#")+1) ) ){ // "qwosp#".endswith("me#")
               
                int offset = word.indexOf(encodedStr.substring(0,encodedStr.indexOf("#")+1));
                for(int j=0; j<i; j++){
                    indices[j] += offset;
                }
                indices[i] = 0;
                encodedStr = encodedStr.replace(encodedStr.substring(0,encodedStr.indexOf("#")+1), word);
                
                
                
            }else{
                encodedStr += words[i] + "#";  // str = "p#grah#", words[2]= qwosp, word = qwosp#
                // [0,2]1
                indices[i] = encodedStr.lastIndexOf(words[i]);
            }
        }
        
        System.out.println(encodedStr);
        
        return encodedStr.length();
        
        
        // time#
        // [2, 0]
    }
}