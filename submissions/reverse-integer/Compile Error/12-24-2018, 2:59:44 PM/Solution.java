// https://leetcode.com/problems/reverse-integer

class Solution {
    public int reverse(int x) {
      
        char[] chars = ("" + x).toCharArray();
       String tmps =  "";
         
        if( "-".equals(chars[0])){
            tmps = "-";
            chars[0] = "0";
        }
    
        
         int n = chars.length;
         for(int i=0; i<n; i++){
             tmps += chars[n-i-1];
             
             
            // char tmp = chars[i];
            // chars[i] = chars[n-i];
            // chars[n-i] = tmp;
        }
        System.out.println(tmps);
        
        
        int res = Integer.parseInt(String.valueOf(tmps)); 
        return res;
    }
}