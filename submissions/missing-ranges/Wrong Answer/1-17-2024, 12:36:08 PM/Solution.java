// https://leetcode.com/problems/missing-ranges

class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        
        /*
        Input: nums = [0,1,3,50,75], lower = 0, upper = 99
        Output: [[2,2],[4,49],[51,74],[76,99]]
        */
        if(len==0){
            res.add(Arrays.asList(new Integer[]{lower, upper}));
            return res;
        }
        
        
        boolean addHead=false, addTail=false;
        
        if(len>0){
            if(nums[0]!=lower){
                addHead = true;
            }
            
            if(nums[len-1]!=upper){
                addTail=true;
            }
        }
        
        if(addHead && addTail){
            int[] t = new int[len+2];
            t[0] = lower;
            t[len+1] = upper;
            System.arraycopy(nums, 0, t, 1, len);
            nums =t ;
        }else if(addHead){
            int[] t = new int[len+1];
            t[0] = lower;
            System.arraycopy(nums, 0, t, 1, len);
            nums =t ;
        }else if(addTail){
            int[] t = new int[len+1];
            t[len] = upper;
            System.arraycopy(nums, 0, t, 0, len);
            nums =t ;
        }
        
        // find starting point;
        for(int i=0; i<nums.length-1; i++){
            int st = nums[i]+1;
            int ed = nums[i+1]-1; 
            
            if(st>ed) continue;
            
            res.add(Arrays.asList(new Integer[]{i==0 ? st-1 : st, i==nums.length-2 ? ed+1 : ed}));
        }
        
        return res;
    }
}