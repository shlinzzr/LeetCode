// https://leetcode.com/problems/maximum-odd-binary-number

class Solution {
    public String maximumOddBinaryNumber(String s) {
        char[] arr = s.toCharArray();
        
        int cnt= 0 ;
        
        for(int i=0; i<arr.length; i++){
            if(arr[i]=='1')
                cnt++;
        }
        
        
        arr[arr.length-1]='1';
        cnt--; 
        
        int idx = 0;
        while(cnt-->0){
          arr[idx++]='1';
            
        }
        
       while(idx<arr.length-1){
           arr[idx++]='0';
       }
        
        return new String(arr);
    }
}