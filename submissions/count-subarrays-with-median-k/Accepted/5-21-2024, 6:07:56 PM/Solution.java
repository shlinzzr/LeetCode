// https://leetcode.com/problems/count-subarrays-with-median-k

class Solution {
    public int countSubarrays(int[] nums, int k) {
        int idx =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==k){
                idx = i;
                break;
            }
        }

        // 3 2 1 4 5
        //-3-2-1 0 1

        Map<Integer, Integer> map = new HashMap<>(); // sum, cnt
        int sum =0;
        for(int i =idx;i<nums.length;i++){ //從中位數往右找
            sum += nums[i]==k? 0 : nums[i]<k? -1 :1;
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        
        // map : 0:1, 1:1


        int res = 0;
        sum =0;
        for(int i= idx;i>=0.;i--){ //從中位數往左找
            sum += nums[i]==k? 0 : nums[i]<k? -1 :1;
            res+= map.getOrDefault(-sum,0) 
                 + map.getOrDefault(-sum+1,0);//因為 sum+(-sum+1)/2 也是median
            
            //比如說我現在sum到-6 那如果前有sum到5 那我也還算是median
            // ex k = 4
            //  3  2  1  2  0  1 4 5 6 7 8 9
            // -6 -5 -4 -3 -2 -1 0 1 2 3 4 5


            // [-1, 0, 1]   sum=0, median=0
            // [-1, 0, 1, 1] sum=1, median=0
        }
        return res;
    }
    
    
    
    // 1 [4, 5] 
    
    //[2,3,1]
    
    // st=2 ed=2 k=3
    
    // private int extend(int[] nums, int st, int ed, int k){
    //     int cnt=0;
    //     int pre=0, post=0;
        
    //     int len = nums.length;
        
    //     while(st>=0 && ed<len && pre==post){
            
            
            
            
    //         if(nums[st]==k || nums[ed]==k){
    //             pre++;
    //             post++;
    //             st--;
    //             ed++;
    //             cnt++;
    //             continue;
    //         }
            
    //         if(nums[st]<k){
    //             pre++;
    //             st--;
    //         }
                
            
    //         if(nums[ed]>k){
    //             post++;
    //             ed++;
    //         }
            
    //         if(pre==post)
    //             cnt++;
    //     }
        
    //     return cnt;
        
        
    // }
}