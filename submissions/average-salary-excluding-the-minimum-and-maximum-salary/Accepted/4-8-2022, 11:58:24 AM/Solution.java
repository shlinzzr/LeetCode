// https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary

// import java.math.BigDecimal;
// import java.math.RoundingMode;

import java.text.DecimalFormat;

class Solution {
    public double average(int[] salary) {
        int min=Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        double total=0;
        
        for(int s : salary){
           min = Math.min(s, min);
            max = Math.max(s, max);
            
            total += s;
        }
        
        
        
        return  (total - min - max ) / (salary.length-2) ;
    }
}