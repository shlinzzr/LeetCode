// https://leetcode.com/problems/minimum-time-to-make-rope-colorful

class Solution {
    public int minCost(String colors, int[] neededTime) {
       
        int cost =0 ;
        int len = colors.length();
        int i=0, j=0;
        while (i < neededTime.length && j < neededTime.length) {
            int currTotal = 0, currMax = 0;

            while(j<len && colors.charAt(i)== colors.charAt(j)){
               
                currTotal += neededTime[j];
                currMax = Math.max(currMax, neededTime[j]);
                 j++;
            }

            cost += currTotal-currMax;
            i=j;
        }

        return cost;
    }
}