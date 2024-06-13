// https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary

import java.math.BigDecimal;

import java.math.RoundingMode;

class Solution {
    public double average(int[] salary) {
        int min=100000000;
        int max = 0;
        
        int total=0;
        
        for(int s : salary){
            if(s<min)
                min=s;
            if(s>max)
                max=s;
            
            total += s;
        }
        
        
         BigDecimal bd = new BigDecimal((total - min - max ) / (salary.length-2)).setScale(5);
        
        return bd.doubleValue();
    }
}