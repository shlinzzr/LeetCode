// https://leetcode.com/problems/length-of-the-longest-subsequence-that-sums-to-target

class Solution {
    int max = -1;
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        Collections.sort(nums);
        
//         helper(nums, new ArrayList<>(), target, 0);
    
        
//         return max;
        
        
        int size = nums.size();
        
        int st=1, ed=size;
        
        while(st<ed){
            int mid = (st+ed)/2;
            if(isOk(nums, mid, target, 0)){
                st = mid+1;
            }else{
                ed = mid;
            }
        }
        System.out.println(st);
        return isOk(nums, st, target, 0)? st : -1;
        
        
    }
    
    
    
    
    private boolean isOk(List<Integer> nums, int mid, int target, int st){
        
        if(mid<0)
            return false;
        
        if(target<0)
            return false;
        
        if(target==0)
            return true;
        
        for(int i=st; i<nums.size(); i++){
            if(nums.get(i)<target){
                isOk(nums, mid-1, target-nums.get(i), i+1);
            }
        }
        return false;
        
    }
    
    // TLE
    private void helper(List<Integer> nums, List<Integer> curr, int target, int st){
        
        if(max!=-1)
            return;
        
        if(target<0)
            return;
        
        if(target==0){
            max = Math.max(max, curr.size());
            System.out.println(curr);
            return;
        }
        
        for(int i=st; i<nums.size(); i++){
            if(nums.get(i)>target)
                return;
            
            curr.add(nums.get(i));
            helper(nums, curr, target-nums.get(i), i+1);
            curr.remove(curr.size()-1);
            
        }
    }
}