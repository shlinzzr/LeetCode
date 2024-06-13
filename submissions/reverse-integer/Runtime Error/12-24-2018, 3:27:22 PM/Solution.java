// https://leetcode.com/problems/reverse-integer

class Solution {
    public int reverse(int x) {
      
        char[] chars = ("" + x).toCharArray();
       String tmps =  "";
         
        if( '-' == chars[0] && chars.length > 0){
            tmps = "-";
            
        }
        
     
         int n = chars.length;
         for(int i=0; i<n-1; i++){
             if(!"-".equals(chars[n-i-1]))
             tmps += chars[n-i-1];
             
             
            // char tmp = chars[i];
            // chars[i] = chars[n-i];
            // chars[n-i] = tmp;
        }
        System.out.println(tmps);
        
       
        int res = 0;
        if(tmps.length() >0  ) 
            res = Integer.parseInt(tmps); 
        
        if(res < Integer.MIN_VALUE || res > Integer.MAX_VALUE )  
            return 0;
        
        return res ;
    }
}