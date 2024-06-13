// https://leetcode.com/problems/add-binary

class Solution {
    public String addBinary(String a, String b) {
        int lena = a.length();
        int lenb = b.length();
        
        int ia = lena-1;
        int ib = lenb-1;
        
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(ia>=0 || ib>=0){
            int sum = carry;
            if(ia>=0) sum+=a.charAt(ia--)-'0';
            if(ib>=0) sum+=b.charAt(ib--)-'0';
            sb.append(sum%2);
            carry = sum/2;
        }
        
        if(carry==1)
            sb.append(1);
        
        return sb.reverse().toString();
            
    }
}