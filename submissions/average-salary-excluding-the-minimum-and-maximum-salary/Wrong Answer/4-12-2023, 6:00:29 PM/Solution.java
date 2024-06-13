// https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary

class Solution {
    public double average(int[] salary) {
        
        
        int max =0;
        
        int min = 10000000;
        long total = 0;
        for(int n: salary){
            total+=n;
            max = Math.max(max, n);
            min = Math.min(min, n);
        }
        System.out.println(total);
        System.out.println(max);
        System.out.println(min);
        
        return (total-max-min)/(salary.length-2);
        
    }
}
