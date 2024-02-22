// https://leetcode.com/problems/height-checker

class Solution {
    public int heightChecker(int[] heights) {
        int cnt= 0;
        int[] org  = Arrays.copyOf(heights, heights.length);
        Arrays.sort(heights);
        for(int i=0; i<heights.length; i++){
            if(heights[i]!=org[i])
                cnt++;
            
        }
        
        return cnt;
    }
}