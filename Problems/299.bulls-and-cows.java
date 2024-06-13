// https://leetcode.com/problems/bulls-and-cows

class Solution {
    public String getHint(String secret, String guess) {
        
        // bulls (x): correct
        // cows (y) : correct num but wrong pos
        
        int arr[] = new int[10];
        
        
        int len = secret.length();
        
        int x = 0;
        for(int i=0; i<len; i++){
            
            if(secret.charAt(i)==guess.charAt(i)){
                x++;
                continue;
            }
            
            
            char ch = secret.charAt(i);
            arr[ch-'0']++;
        }
        
        int y = 0;
        for(int i=0; i<len; i++){
            if(secret.charAt(i)==guess.charAt(i)){
                continue;
            }
            
            char ch = guess.charAt(i);
            if(arr[ch-'0']>0){
                y++;
                arr[ch-'0']--;
                
            }
        }
        
        return x+"A"+y+"B";
        
        
    }
}