// https://leetcode.com/problems/bulls-and-cows

class Solution {
    public String getHint(String secret, String guess) {
        
        int[] arr = new int[10];
        
        int bulls=0;
        for(int i=0; i<secret.length(); i++){
            
            char c = secret.charAt(i);
            arr[c-'0']++;
            if(secret.charAt(i)==guess.charAt(i)){
                arr[c-'0']--;
                bulls++;
            }
        }
        
        
        int cows =0;
        for(int i=0; i<secret.length(); i++){
            
            if(secret.charAt(i)!=guess.charAt(i)
              && arr[guess.charAt(i)-'0']>0){
                arr[guess.charAt(i)-'0']--;
                cows++;
            }
                
        }
        
        
        return bulls + "A" + cows + "B";
        
        
    }
}