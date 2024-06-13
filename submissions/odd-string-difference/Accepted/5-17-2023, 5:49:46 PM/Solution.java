// https://leetcode.com/problems/odd-string-difference

class Solution {
    public String oddString(String[] words) {
        int len = words.length;
        int wordLen = words[0].length();
        
        for(int i=0; i<len-2; i++){
            String w0 = words[i];
            String w1 = words[i+1];
            String w2 = words[i+2];
            
            int[] arr = new int[wordLen-1];
            
            for(int j=0; j<wordLen-1; j++){
                
                int a = w0.charAt(j+1)-w0.charAt(j);
                int b = w1.charAt(j+1)-w1.charAt(j);
                int c = w2.charAt(j+1)-w2.charAt(j);
                
                if(a!=b && a!=c && b==c){
                    return words[i];
                }else if(a!=b && b!=c && a==c){
                    return words[i+1];
                }else if(a==b && a!=c && b!=c){
                    return words[i+2];
                }
            }
        }
        
        return "";
        
        
    }
}
