// https://leetcode.com/problems/multiply-strings

class Solution {
    public String multiply(String num1, String num2) {
     
        if(num1.equals("0"))
            return num2;
        
        if(num2.equals("0"))
            return num1;
        
        int[] arr = new int[num1.length() + num2.length()-1];
        
        
        for(int i=num1.length()-1; i>=0; i--){
            for(int j=num2.length()-1; j>=0; j--){
                
                arr[i+j] += (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
            }
        }
        
        for(int i=arr.length-1; i>0; i--){
            arr[i-1] += arr[i]/10;
            arr[i] =  arr[i]%10;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int a: arr)
            sb.append(String.valueOf(a));
        
        return sb.toString();
        
        
    }
}