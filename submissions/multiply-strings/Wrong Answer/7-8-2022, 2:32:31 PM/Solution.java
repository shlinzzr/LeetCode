// https://leetcode.com/problems/multiply-strings

class Solution {
    public String multiply(String num1, String num2) {
        
        
        int n1 = 0;
        int carry = 1;
        for(int i=num1.length()-1; i>=0;i--){
            n1 += carry * (num1.charAt(i)  - '0');
            carry *= 10;
        }
        
        
        int n2 = 0;
        carry = 1;
        for(int i=num2.length()-1; i>=0;i--){
            n2 += carry * (num2.charAt(i)  - '0');
            carry *= 10;
        }
        
        System.out.println(n1 + " " + n2);
        
        
        return String.valueOf(n1*n2);
        
    }
}