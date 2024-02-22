// https://leetcode.com/problems/check-if-the-number-is-fascinating

class Solution {
    
     boolean[] arr;
    public boolean isFascinating(int n) {
        
        arr =new boolean[10];
        arr[0]=true;
        
        
        return  helper(n) && helper(2*n) && helper(3*n);
        
        
    }
    
    private boolean helper(int n){
        String s = String.valueOf(n);
        for(int i=0; i<s.length(); i++){
            
            int k = s.charAt(i)-'0';
            
            if(arr[k]==true)
                return false;
            
            arr[k]=true;
        }
        
        return true;
    }
    
    // 267 534    801
}