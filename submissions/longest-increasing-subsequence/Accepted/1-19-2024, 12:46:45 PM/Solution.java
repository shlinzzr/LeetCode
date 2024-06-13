// https://leetcode.com/problems/longest-increasing-subsequence

class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int len = nums.length;
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<len; i++){
            
            if(list.isEmpty() || list.get(list.size()-1)<nums[i]){
                list.add(nums[i]);
            }else{
                
                int idx = binarySearch(list, nums[i]);
                list.set(idx, nums[i]);
            }
        }
        
        return list.size();
        
    }
    
    private int binarySearch(List<Integer> list , int x){
        
        // find the first number greater than x int list
        
        int st=0, ed=list.size()-1;
        
        while(st<ed){
            int mid = st+(ed-st)/2;
            
            if(list.get(mid)==x){
                return mid;
            }else if(list.get(mid)<x){
                st = mid+1;
            }else{
                ed = mid;
            }
        }
        
        return st;
        
    }
}