// https://leetcode.com/problems/multiply-strings

class Solution {
    public String multiply(String num1, String num2) {
        
        if("0".equals(num1) || "0".equals(num2))
            return "0";
        
        
        int[] arr = new int [num1.length()+num2.length()-1];
        
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=num1.length()-1; i>=0;i--){
            for(int j=num2.length()-1; j>=0;j--){
                arr[i+j] += (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
            }
        }
        
        
        for(int i=arr.length-1; i>0;i--){
            
            arr[i-1] += arr[i]/10;
            arr[i] = arr[i]%10;
            
        }
        
        for(int i:arr){
            sb.append(i);
        }
        
        
        
        
        
        return sb.toString();
        
//         int n1 = 0;
//         int carry = 1;
//         for(int i=num1.length()-1; i>=0;i--){
//             n1 += carry * (num1.charAt(i)  - '0');
//             carry *= 10;
//         }
        
        
//         int n2 = 0;
//         carry = 1;
//         for(int i=num2.length()-1; i>=0;i--){
//             n2 += carry * (num2.charAt(i)  - '0');
//             carry *= 10;
//         }
        
//         // System.out.println(n1 + " " + n2);
        
        
//         return String.valueOf(n1*n2);
        
    }
}