// https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary

// import java.math.BigDecimal;
// import java.math.RoundingMode;

import java.text.DecimalFormat;

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
        
        
        
         DecimalFormat df = new DecimalFormat("###.00000");
        // double value = Math.round(((total - min - max ) / (salary.length-2))*1e5)/1e5;
        
         // double roundDbl = Math.round(d*100.0)/100.0;
         // BigDecimal bd = new BigDecimal((total - min - max ) / (salary.length-2)).setScale(5);
        
        
        
        return  (total - min - max ) / (salary.length-2) ;
    }
}