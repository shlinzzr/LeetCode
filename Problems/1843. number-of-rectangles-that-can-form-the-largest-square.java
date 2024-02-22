// https://leetcode.com/problems/number-of-rectangles-that-can-form-the-largest-square

class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int len = rectangles.length;
        int[] arr = new int[len];
        
        for(int i=0; i<len; i++){
            int [] rect = rectangles[i];
            arr[i] = Math.min(rect[0], rect[1]);
        }
        
        int res = 0, max=0;
        
        for(int a : arr){
            if(max<a){
                max=a;
                res=1;
            }else if(max==a){
                res++;
            }
        }
        
        return res;
    }
    
}