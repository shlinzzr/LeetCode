// https://leetcode.com/problems/find-peak-element

class Solution {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        
        if(len==1) return 0;
        
        if(len==2){
            if(nums[0]>nums[1]) return 0;
            else  return 1;
        }
        
        int[] arr = new int[len+2];
        System.arraycopy(nums, 0, arr, 1, len);
        arr[0] = Integer.MIN_VALUE;
        arr[arr.length-1]= Integer.MIN_VALUE;
        
        int st=1, ed=arr.length-2;
        
        while(st<ed){
            int m = st+(ed-st)/2; 
            
            if(arr[m-1] < arr[m] && arr[m]>arr[m+1]){
                return m-1;
            }else if(arr[m]< arr[m+1]){
                st = m+1; 
                
            }else { 
                ed = m-1; 
            }
        }
        
        return st-1;
    }
    
    
    //[1,2,1,3,5,6,4]
         // st  m   ed
    
    //[6,5,4,3,2,3,2]
    // [min, 1,2,3, min]
            // st m ed
    
}