// https://leetcode.com/problems/missing-element-in-sorted-array

class Solution {
    public int missingElement(int[] nums, int k) {
        
        int len = nums.length;
        int st =0, ed =len-1;
        while(st<ed){
            
            int mid = st+(ed-st)/2;
            System.out.println (st + " " + ed + " m=" + mid + " val= " + (nums[mid]-nums[0]-mid));
            int missingCnt = nums[mid]-nums[0] - mid; // 0到mid有幾個missing number
            
            if(missingCnt < k){  
                st = mid+1;
            }else{
                ed = mid;
            }
        }
        
         int missingCnt = nums[st]-nums[0] - st;
          System.out.println ("final st=" + st + " " + ed +  " missingCnt= " + missingCnt);
        
        return missingCnt<k ? nums[ed] + k -missingCnt : nums[st] +k-missingCnt ;
        
    }
}