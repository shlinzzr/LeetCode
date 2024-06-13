// https://leetcode.com/problems/add-binary

class Solution {
    public String addBinary(String a, String b) {
        
        String ra = new StringBuilder(a).reverse().toString();
        String rb = new StringBuilder(b).reverse().toString();
        
        
        int len = Math.max(a.length(), b.length());
        int carry=0;
        String res = "";
        
        for(int i=0; i<len; i++){
            
                int ia = (i<a.length()) ? ra.charAt(i)-'0' : 0;
                int ib = (i<b.length()) ? rb.charAt(i)-'0' : 0;
                
                int sum = ia + ib + carry;
                int d = sum%2;
                carry = sum/2;
                res+=String.valueOf(d);            
        }
            
        if(carry==1)
            res+="1";
            
        
        return new StringBuilder(res).reverse().toString();
            
            
        
        
    }
}