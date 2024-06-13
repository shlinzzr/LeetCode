// https://leetcode.com/problems/count-asterisks

class Solution {
    public int countAsterisks(String s) {
        String[] arr = s.split("\\|");
        
        
        int cnt =0;
        for(int i=0; i<arr.length; i++){
            
            if(i%2==0){
                
                String str = arr[i];
                for(char c : str.toCharArray()){
                    if(c=='*')
                        cnt++;
                }
            }
                
            
        }
        
        return cnt;
    }
    
}