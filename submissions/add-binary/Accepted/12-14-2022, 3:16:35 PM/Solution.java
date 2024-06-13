// https://leetcode.com/problems/add-binary

class Solution {
    public String addBinary(String a, String b) {
        int ai = a.length()-1;
        int bi = b.length()-1;
        int carry =0;
        
        StringBuilder sb = new StringBuilder();
        
        while(ai>=0 || bi>=0 || carry>0){
            int sum = carry;
            if(ai>=0){
                sum += a.charAt(ai)-'0';
                ai--;
            }
            
            if(bi>=0){
                sum += b.charAt(bi)-'0';
                bi--;
            }
            
            carry = sum /2;
            
            String str  = String.valueOf(sum %2);
            
            sb.insert(0, str);
        }
        
        if(carry>0)
            sb.insert(0, "1");
        
        return sb.toString();
    }
}