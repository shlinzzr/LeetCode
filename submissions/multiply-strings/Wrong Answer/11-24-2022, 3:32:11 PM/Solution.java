// https://leetcode.com/problems/multiply-strings

class Solution {
    public String multiply(String num1, String num2) {
        if("0".equals(num1) || "0".equals(num2))
            return "0";
        
        int[] arr = new int[num1.length() + num2.length()-1]; 
        
        for(int i=0; i<num1.length(); i++){
            for(int j=0; j<num2.length(); j++){
                arr[i+j] = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
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