// https://leetcode.com/problems/add-strings

class Solution {
    public String addStrings(String num1, String num2) {
        
        
        int l1= num1.length();
        int l2 = num2.length();
        int i1 = l1-1;
        int i2 = l2-1;
        
        int carry=0;
        
        StringBuilder sb= new StringBuilder();
        while(i1>=0 || i2>=0){
            
            int sum = carry;
            if(i1>=0){
                sum += num1.charAt(i1)-'0';
                i1--;
            }
            
            if(i2>=0){
                sum += num2.charAt(i2)-'0';
                i2--;
            }
            // System.out.println(sum);
            
            carry = sum/10;
            sb.insert(0 , sum%10);            
        }
        
        if(carry>0){
            sb.insert(0, carry);
        }
        
        return sb.toString();
        
        
    }
}