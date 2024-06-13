// https://leetcode.com/problems/minimum-time-to-make-rope-colorful

class Solution {
    public int minCost(String colors, int[] neededTime) {
       
        int cost = 0;
        for(int i=0; i<colors.length()-1; i++){
            char a = colors.charAt(i);
            char b = colors.charAt(i+1);
            
            if(a==b){
                if(neededTime[i]<=neededTime[i+1]){
                    cost += neededTime[i];
                }else{
                    cost += neededTime[i+1];
                    i++;
                }
            }

        }

        return cost;
    }
}