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
        
        //要再確認一次。 ＝> 因為bs有可能找到k的第一個 或k-1的最後一個
        //如果是k的第一個 可以不用動, 如果是k-1的最後一個 要+1 使之成為第k個offset
        
         int missingCnt = nums[st]-nums[0]-st;
         int mid = st;
         System.out.println("st="+st + " ed="+ed + " mc="+missingCnt);
        
         if(missingCnt < k){
                st=mid+1;
         }else{
                ed=mid;
         }
        
        
        //公式: 第一個數字開始 + offset + 第k個-1
        return nums[0] + st + k - 1;
        
        
      
    }
        
}