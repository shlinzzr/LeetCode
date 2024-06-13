// https://leetcode.com/problems/harshad-number

class Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        
        int sum = 0;
        
        int d = 0;
        int t = x;
        while(t>0){
            d+= t%10;
            t/=10;
            
        }
        
        return x%d==0 ? d : -1;
    }
}