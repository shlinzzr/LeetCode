// https://leetcode.com/problems/handling-sum-queries-after-update

class Solution {
    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        cal(nums1, nums2, queries[0]);
        cal(nums1, nums2, queries[1]);
        
        long res = 0;
        for(int i=0; i<nums2.length; i++){
            res+=nums2[i];
        }
        
        return new long[]{res};
        
        
        
        
    }
    
    private void cal(int[] nums1, int[] nums2, int[] q){
        
        if(q[0]==1){
            
            for(int i=q[1]; i<=q[2]; i++){
                if(nums1[i]==0){
                    nums1[i]=1;
                }else{
                    nums1[i]=0;
                }
            }
            
        }else if(q[0]==2){
            
            for(int i=0; i<nums1.length;i++){
                nums2[i] = nums2[i] + nums1[i] * q[1];
            }
            
        }
        
        
    }
}