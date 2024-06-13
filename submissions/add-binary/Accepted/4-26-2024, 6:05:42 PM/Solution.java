// https://leetcode.com/problems/add-binary

class Solution {
    public String addBinary(String a, String b) {
        
        int aLen = a.length();
        int bLen = b.length();
        
        int ai=aLen-1, bi=bLen-1;
        StringBuilder sb = new StringBuilder();
        
        int carry = 0;
        while(ai>=0 && bi>=0){
            
            int va = a.charAt(ai--)-'0';
            int vb = b.charAt(bi--)-'0';
            
            int val =va+vb+carry; 
            carry = val/2;
            
            sb.append(val%2);
        }
        
        while(ai>=0){
            int va = a.charAt(ai--)-'0';
            int val =va+carry; 
            carry = val/2;
            sb.append(val%2);
        }
        
        while(bi>=0){
            int vb = b.charAt(bi--)-'0';
            int val = vb+carry; 
            carry = val/2;
            sb.append(val%2);
        }
        
        if(carry>0){
            sb.append(1);
        }
        
        return sb.reverse().toString();
        
    }
}