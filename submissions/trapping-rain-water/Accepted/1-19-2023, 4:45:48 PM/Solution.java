// https://leetcode.com/problems/trapping-rain-water

class Solution {
    public int trap(int[] height) {
        int len  = height.length;
        int[] left = new int[len];
        int[] right = new int[len];
        
        int max=0;
        for(int i=0; i<len;i++){
            max = Math.max(max, height[i]);
            left[i]=max;
        }
        
        max=0;
        for(int i=len-1; i>=0;i--){
            max = Math.max(max, height[i]);
            right[i]=max;
        }
        
        
        int cnt=0;
        for(int i=0; i<len;i++){
            
            // System.out.println(left[i]+" " + right[i]+ " "+height[i]);
            
            int cur =  Math.min(left[i], right[i]) - height[i];
            // System.out.println(cur);
            cnt+=cur;
            
        }
        
        return cnt;
    }
}