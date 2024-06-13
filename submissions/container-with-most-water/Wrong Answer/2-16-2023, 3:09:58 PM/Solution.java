// https://leetcode.com/problems/container-with-most-water

class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        
        Stack<Integer> st = new Stack<>();
        int[] left = new int[len];
        int max = 0;
        for(int i=0; i<len; i++){
            
            if(height[i]>height[max]){
                max = i;
            }
            left[i] = max;          
        }
        
        
//         for(int l : left){
//             System.out.print(l+ ", ");
//         }
//         System.out.println();
        
        int[] right = new int[len];
        max = 0;
        for(int i=len-1; i>=0; i--){
            if(height[i]>height[max]){
                max = i;
            }
            right[i] = max;          
        }
        
//          for(int r : right){
//             System.out.print(r+ ", ");
//         }
//         System.out.println();
        
        
        max = 0;
        for(int i=0; i<len; i++){
            // System.out.println("i="+i + " max="+(right[i]-left[i]-1)*Math.min(height[right[i]], height[left[i]]));
            
            max = Math.max(max, (right[i]-left[i])*Math.min(height[right[i]], height[left[i]]));
        }
        return max;
        
    }
}