// https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers

class Solution {
    public int minPartitions(String num) {
        // initialization
        char maxDigit = '0';
        
        // iterate over each digit in num
        // to get the maximum digit
        for(char digit : num.toCharArray()){
            maxDigit = (char)Math.max(maxDigit, digit);
        }
        
        // return the digit
        return maxDigit - '0';
    }
}