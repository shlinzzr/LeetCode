// https://leetcode.com/problems/find-the-number-of-good-pairs-ii

class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        
        int m = nums1.length;
        int n = nums2.length;
        int cnt = 0;
        
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        
        for(int i=0; i<m; i++){
            
            
            
            if(nums1[i]%k!=0) continue;
            
            
            map1.put(nums1[i], map1.getOrDefault(nums1[i],0)+1);
            
        }
        
        
        
        for(int j=0; j<n; j++){
            map2.put(nums2[j], map2.getOrDefault(nums2[j],0)+1);            
        }
        
        for(int k1 : map1.keySet()){
            for(int k2 : map2.keySet()){
                if(k1%k2==0   ){
                    cnt+= map1.get(k1)*map2.get(k2);
                }
            }
        }
        
        return cnt;
        
    }
}