// https://leetcode.com/problems/missing-element-in-sorted-array

class Solution {
    public int missingElement(int[] nums, int k) {
     
        // 今天比昨天厲害  https://www.youtube.com/watch?v=RJP0meMf5vg&t=407s
        
        int len = nums.length;
        int st =0, ed=len-1;
        while(st<ed){
            
            int mid =  st +(ed-st)/2;
            
            int missingCnt = nums[mid]-nums[0]-mid;
            
            System.out.println("st=" + st + " ed=" + ed + " mid=" + mid + " missingCnt=" + missingCnt + " (missingCnt<k):" + (missingCnt<k) + " => " + ((missingCnt<k) ? "st=mid+1" : "ed=mid"));
            
            if(missingCnt < k){ // 要找的是"第一個" 差距為k的數字  => 有可能找到k的第一個 或k-1的最後一個
                st = mid+1;
            }else{
                ed = mid;
            }
        }
        
        /* 4 7 9 10
        st =2
        
        4->9  : 5 6 7 8
                    x
        */
        
         int missingCnt = nums[st]-nums[0]-st;
        
         System.out.println("st="+st + " ed="+ed + " mc="+missingCnt);
        
         if(missingCnt < k){
                st=st+1;
         }else{
                ed = st;
         }
        
        // System.out.println("st="+st + " ed="+ed + " mc="+missingCnt);
        
        
        return nums[0] + k + st - 1;
        
        
      
    }
        
}