// https://leetcode.com/problems/buildings-with-an-ocean-view


class Solution {
    public int[] findBuildings(int[] heights) {
        int n = heights.length;
        boolean[] hasView = new boolean[n];
        int currentMax = Integer.MIN_VALUE;
        int count = 0;
        
        for(int i = n - 1; i >= 0; i--){
            if(heights[i] <= currentMax) continue;
            
            currentMax = heights[i];
            hasView[i] = true;
            count++;
        }
        
        int[] res = new int[count];
        int index = 0;
        for(int i = 0; i < n; i++){
            if(!hasView[i]) continue;
            res[index++] = i;
        }
        
        return res;
    }
}