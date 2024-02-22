// https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int len = nums.length;
        
        
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        long sum=0;
        long max = 0;
        Integer prev = null;
        int st=0;
        for(int ed=0; ed<len; ed++){
            
            
            if(set.contains(nums[ed])){
                
                while(!q.isEmpty()){
                    int p = q.poll();
                    set.remove(p);
                    st++;
                    sum-=p;
                    if(p==nums[ed])
                        break;
                }
            }
            
            q.offer(nums[ed]);
            set.add(nums[ed]);
            sum += nums[ed];
            if(ed-st+1<k){
                continue;
            }
            
            max = Math.max(max, sum);
            
            set.remove(nums[st]);
            q.poll();
            sum-=nums[st++];
        }
        
        return max;
        
    }
}