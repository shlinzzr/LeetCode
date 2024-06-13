// https://leetcode.com/problems/3sum-closest

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        Arrays.sort(nums);
        
        int len = nums.length;
        
        int min = Integer.MAX_VALUE;  
        int res = 0;                     
        
        /*
        -4 -1 1 2
        i. j. st ed
              mid
        
        */
        
        
        for(int i=0; i<len-2; i++){
            for(int j=i+1; j<len-1; j++){
                
                int st = j+1, ed = len-1;
                
                while(st<=ed){
                    
                    int mid = st+(ed-st)/2;
                    
                    int sum = nums[i]+nums[j]+nums[st];
                    
                    int abs = Math.abs(sum-target);
                    if(abs<min){
                        res = sum;
                        min = abs;
                    }
                    
                    //  System.out.println("abs="+abs + " res="+res);
                    // System.out.println("i=" + i + " j=" + j + " st=" + st + " ed=" + ed + " m=" + mid  + " sum =" + sum );
                    
                    if(nums[i]+nums[j]+nums[mid]==target)
                        return target;
                    else if(nums[i]+nums[j]+nums[mid]>target){
                        ed = mid-1;
                        
                    }else 
                        st = mid+1;
                }
            }
        }
        
        return res;
    }
}