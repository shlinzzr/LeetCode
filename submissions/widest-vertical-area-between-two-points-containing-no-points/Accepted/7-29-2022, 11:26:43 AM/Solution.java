// https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points

class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int[] arr = new int[points.length];
        
        
        int c=0;
        for(int[] point : points){
            int x = point[0];
            arr[c++]=x;
        }
        Arrays.sort(arr);
        
        
        int max=0;
        for(int i=0; i<arr.length-1; i++){
            if(arr[i+1]-arr[i] > max)
                max = arr[i+1]-arr[i];
        }
        
        return max;
        
        
    }
}