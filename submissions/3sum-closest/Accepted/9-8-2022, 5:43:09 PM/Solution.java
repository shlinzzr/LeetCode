// https://leetcode.com/problems/3sum-closest

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        TreeSet<Integer> set = new TreeSet<>();
        Arrays.sort(nums);
          
        int resAbs = Integer.MAX_VALUE;
        int res = -1000;
        
        for(int i=0; i<nums.length; i++){
            
            int j = i+1;
            int k = nums.length-1;
            
            while(j<k){
                
                int sum = nums[i] + nums[j] + nums[k];
                
                int disAbs = Math.abs( sum-target );
                if(disAbs<resAbs){
                    resAbs = disAbs;
                    res = sum ;
                }
                
                
                if (sum > target) {
                    k--;
                } else {
                    j++;
                }
                
                
                // if(!set.contains(sum)){
                //     set.add(sum);
                //     int floor = set.floor(target)!=null? set.floor(target) : Integer.MIN_VALUE;
                //     int ceil = set.ceiling(target)!=null? set.ceiling(target) : Integer.MAX_VALUE;                                           
                // }
            }
        }
        
        return res;
        
        
    }
}