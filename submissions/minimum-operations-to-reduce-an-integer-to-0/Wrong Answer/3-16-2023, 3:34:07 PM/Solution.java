// https://leetcode.com/problems/minimum-operations-to-reduce-an-integer-to-0

class Solution {
    public int minOperations(int n) {
        String s = Integer.toBinaryString(n);
        System.out.println(s);
        int cnt =0;
        boolean prev = false;
        int len=0;
        
        
        int zero=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='0')
                zero++;
        }
        
        
        boolean toZero=false;
        
        if(zero > s.length()/2)
            toZero=true;
        
        char onebit = '1';
        char zerobit = '0';
            
        if(toZero){
            onebit = '0';
            zerobit = '1';
        }
            
            
        
        
        
        for(int i=0; i<s.length(); i++){
            if(prev==false && s.charAt(i)==onebit){
                cnt++;
                len=0;
            }
            
            if(s.charAt(i)==onebit)
                len++;
            
                
            
            if(prev==true && s.charAt(i)==zerobit && len>1){
                
                cnt++;
            }
            
            if(s.charAt(i)==zerobit){
                prev=false;
            }
                
            else {
                len++;
                prev=true;
            }
                
        }
        
        return cnt;
        
        
        
    }
}