// https://leetcode.com/problems/roman-to-integer

class Solution {
    public int romanToInt(String s) {
        
        int[] arr = new int[s.length()];
        for(int i=0; i<arr.length; i++){
            char c = s.charAt(i);
            
            if(c=='I')  arr[i]=1;
            if(c=='V')  arr[i]=5;
            if(c=='X')  arr[i]=10;
            if(c=='L')  arr[i]=50;
            if(c=='C')  arr[i]=100;
            if(c=='D')  arr[i]=500;
            if(c=='M')  arr[i]=1000;
        }
        
        int res=0;
        for(int i=0; i<arr.length; i++){
            if(i<arr.length-1 && arr[i]<arr[i+1]){
                res+=-arr[i];
            }else{
                res+=arr[i];
            }
        }
        
        
        return res;
        
        
    }
}