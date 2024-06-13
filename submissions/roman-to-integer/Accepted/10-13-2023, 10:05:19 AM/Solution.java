// https://leetcode.com/problems/roman-to-integer

class Solution {
    public int romanToInt(String s) {
        int len = s.length();
        int[] arr = new int[len];

        int res = 0;

        for(int i=0; i<len; i++){

            char ch = s.charAt(i);

            if(ch=='I') arr[i]=1;
            else if(ch=='V') arr[i] = 5;
            else if(ch=='X') arr[i] = 10;
            else if(ch=='L') arr[i] = 50;
            else if(ch=='C') arr[i] = 100;
            else if(ch=='D') arr[i] = 500;
            else if(ch=='M') arr[i] = 1000;
        }

        for(int i=0; i<len-1; i++){

            if(arr[i]<arr[i+1])
                res-=arr[i];
            else 
                res+=arr[i];
        }

        return res+arr[len-1];



    }
}