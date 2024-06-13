// https://leetcode.com/problems/add-binary

class Solution {
    public String addBinary(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();

        int ia = lenA-1;
        int ib = lenB-1;


        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while(ia>=0 || ib>=0){

            if(ia>=0)
                carry += a.charAt(ia--)-'0';
            if(ib>=0)
                carry += b.charAt(ib--)-'0';
            
            sb.append(carry%2);
            carry /= 2;
        }

        if(carry==1)
            sb.append(1);

        return sb.reverse().toString();
    }
}