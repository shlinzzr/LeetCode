// https://leetcode.com/problems/put-boxes-into-the-warehouse-ii

class Solution {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        
        
        int res = 0;
        int len = boxes.length;
        int st = 0;
        int ed = warehouse.length-1;
        
        Arrays.sort(boxes);
        
        for (int i=len-1; i>=0&st<=ed; i--){
            if(boxes[i]<=warehouse[st]){
                st++;
                res++;
            }
            else if(boxes[i]<=warehouse[ed]){
                ed--;
                res++;
            }
        }
        return res;
                
        
    }
}