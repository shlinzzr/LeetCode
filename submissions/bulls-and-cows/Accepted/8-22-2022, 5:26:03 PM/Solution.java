// https://leetcode.com/problems/bulls-and-cows

class Solution {
    public String getHint(String secret, String guess) {
     
        char[] arr = new char[26];
        int len = secret.length();
        
        int cntA = 0, cntB=0;
        for(int i=0; i<len; i++){
            
            arr[secret.charAt(i)-'0']++;
            
            if(secret.charAt(i) == guess.charAt(i)){
                cntA++;
                arr[secret.charAt(i)-'0']--;
            }            
        }
        
        for(int i=0; i<len; i++){
            
             if(secret.charAt(i) != guess.charAt(i)
              && arr[guess.charAt(i)-'0']>0){
                 arr[guess.charAt(i)-'0']--;
                 cntB++;
             }
            
            
        }
        
        
        
        return cntA+ "A" + cntB + "B";
        
        
    }
}