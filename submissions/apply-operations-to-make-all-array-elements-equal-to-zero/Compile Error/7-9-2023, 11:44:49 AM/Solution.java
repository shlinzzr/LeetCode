// https://leetcode.com/problems/apply-operations-to-make-all-array-elements-equal-to-zero

class Solution {
    public boolean checkArray(int[] nums, int k) {
        int total =0 ;
        for(int n : nums){
            total+=n;
        }
        
        if(total%k!=0)
            return false;
        
        PriorityQueue<int[]> pq= new PriorityQueue<>(
            (a,b) -> b[0]-a[0]==0 ? a[1]-b[1] : b[0]-a[0]
        );
        
        int[] prefix = new int[len];
        for(int i=0;i<len;i++){
            prefix[i] = i==0? 0 : prefix[i-1] + nums[i]; 
        }
        
        
        
        
        for(int i=k-1; i<len-k; i++){
            int idx = (k-1)/2;
            int[] ele = new int[]{ prefix[i]-prefix[i-k-1] ,idx};
            pq.offer(ele);
        }
        
        
        
        while(!pq.isEmpty()){
            
            
        }
        
    }
}