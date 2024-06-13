// https://leetcode.com/problems/multiply-strings

class Solution {
    public String multiply(String num1, String num2) {
        int n1 = strToInt(num1);        
        int n2 = strToInt(num2);
        
        return String.valueOf(n1*n2);
    }
    
    private int strToInt(String s){
        int num=0;
        for(char c : s.toCharArray()){
            num = num*10 + c-'0';
        }
        
        return num;
    }
}