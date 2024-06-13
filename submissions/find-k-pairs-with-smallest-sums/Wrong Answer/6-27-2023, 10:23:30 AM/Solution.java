// https://leetcode.com/problems/find-k-pairs-with-smallest-sums

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>>  res = new ArrayList<>();
        
        int idx1 = 0, idx2=0;
        int len1 = nums1.length, len2 = nums2.length;
        
       
        
        while(idx1<len1 && idx2<len2){
            
            int n1 = nums1[idx1];
            int n2 = nums2[idx2];
            res.add(Arrays.asList(n1, n2));
            k--;
                        
            if(k==0)
                break;
            
            
            if(idx1+1<len1 && idx2+1<len2 ){
                
                if(nums1[idx1+1]+nums2[idx2] <= nums1[idx1] + nums2[idx2+1]){
                    idx1++;
                }else
                    idx2++;
                
            }else if(idx1+1==len1){
                idx2++;
                
            }else{
                idx1++;
            }

            
        }
        
        return res;
        
    }
}