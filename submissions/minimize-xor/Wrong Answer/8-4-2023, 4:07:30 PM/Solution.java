// https://leetcode.com/problems/minimize-xor

class Solution {
    public int minimizeXor(int num1, int num2) {
        /*
           [3 : 0011, 5 : 0101],   [1: 0001, 12: 1100]
           
           x has the same number of set bits as num2, and
           The value x XOR num1 is minimal.
        */
        
        String bin = Integer.toBinaryString(num2);
        int cnt = 0;
        for(char ch : bin.toCharArray()){
            if(ch=='1')
                cnt++;
        }
        
        bin = Integer.toBinaryString(num1);
        
        System.out.println(bin);
        
        StringBuilder sb = new StringBuilder();
        for(char ch : bin.toCharArray()){
            
            if(ch=='1'){
                
                if(cnt>0){
                    cnt--;
                    sb.append('1');    
                }else{
                    sb.append('0');
                }
                
            }else{
               sb.append('0');
            }
        }
        
       
        
        while(cnt>0){
            sb.insert(0, '1');
            cnt--;
        }
        
        
        String val =sb.toString();
        int res = Integer.parseInt(val, 2);
        
        return res;
        
        
        
        
        
        
        
    }
}