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
            t[0] = lower-1;
            t[len+1] = upper+1;
            System.arraycopy(nums, 0, t, 1, len);
            nums =t ;
        }else if(addHead){
            int[] t = new int[len+1];
            t[0] = lower-1;
            System.arraycopy(nums, 0, t, 1, len);
            nums =t ;
        }else if(addTail){
            int[] t = new int[len+1];
            t[len] = upper+1;
            System.arraycopy(nums, 0, t, 0, len);
            nums =t ;
        }
        
        System.out.println(nums.length);
        for(int n: nums){
            System.out.print(n);
        }
                    
        // find starting point;
        for(int i=0; i<nums.length-1; i++){
            int st = nums[i]+1;
            int ed = nums[i+1]-1; 
            
            if(st>ed) continue;
            
            res.add(Arrays.asList(new Integer[]{ st, ed}));
        }
        
        return res;
    }
}