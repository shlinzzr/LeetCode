// https://leetcode.com/problems/k-diff-pairs-in-an-array

class Solution {
    public int findPairs(int[] nums, int k) {
        int len = nums.length;
        
        HashMap<Integer, Integer> map = new HashMap<>();        
        
        int res=0;
        for(int i=0; i<len; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        
        for (Map.Entry <Integer, Integer> entry: map.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            
            if(k==0 && val>1){  // k=0, ex: 1,1,1
                res+=2;
                
            }else{ //k>0
                int n1 = key+k;
                int n2 = key-k;
                
                if(map.containsKey(n1)) res++;
                if(map.containsKey(n2)) res++;
            }
            
        }
        
        return res/2;
        
    }
}