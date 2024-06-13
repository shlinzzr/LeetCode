// https://leetcode.com/problems/find-the-integer-added-to-array-ii

class Solution {
    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        
        int sum2 = 0;
        
        for(int n : nums2){
            sum2+= n;
        }
        
        
        Map<Integer, Integer> map = new HashMap<>();
        int sum1 = 0;
        for(int n : nums1){
            map.put(n, map.getOrDefault(n,0)+1);
            sum1+= n;
        }
        

        
        Arrays.sort(nums1);
        
        int len = nums2.length;
        for(int i=0; i<len ; i++){
            for(int j=i+1; j<len; j++){
                    
                // map.put(nums1[i], map.getOrDefault(nums1[i],0)-1);
                // map.put(nums1[j], map.getOrDefault(nums1[j],0)-1);
                // if(map.get(nums1[i])==0) map.remove(nums[i]);
                // if(map.get(nums1[j])==0) map.remove(nums[j]);
                    
                // 3 3 5 5 
                // 7 7 
                // 16-3-3-14 == -4
                if((sum1-nums1[i]-nums1[j] - sum2)%len==0)
                    return -(sum1-nums1[i]-nums1[j] - sum2)/len;
            }
        }
        return -1;
    }
}