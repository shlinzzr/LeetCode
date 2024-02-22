// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        long st = Integer.MIN_VALUE;
        long ed = Integer.MAX_VALUE;
        
        while(st<ed){
            
            long mid = st+(ed-st)/2;
            int count = countSmallerOrEqual(matrix, mid);
            
            if(count<k){
                st = mid+1;
            }else 
                ed=mid;
            
        }
        
        return (int)st;
        
    
    }
    
    private int countSmallerOrEqual(int[][] matrix, long target){
        int h= matrix.length;
        int w = matrix[0].length;
        
        int i=h-1, j=0;
        
        int count = 0;
        while(i>=0 && j<w){
            if(matrix[i][j]<=target){
                count+= i+1;
                j++;
            }else
                i--;
        }
        
        return count;
    }
}