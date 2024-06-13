// https://leetcode.com/problems/minimum-total-cost-to-make-arrays-unequal

class Solution {
    public long minimumTotalCost(int[] nums1, int[] nums2) {
        
        //huifeng : https://www.youtube.com/watch?v=WGcjEzidnEA
        
        int n = nums1.length;
        HashMap<Integer, Integer>  count = new HashMap<>();
        
        int total = 0;
        long ret = 0;
        for (int i=0; i<n; i++)
        {
            if (nums1[i]==nums2[i])
            {
                count.put(nums1[i], count.getOrDefault(nums1[i], 0)+1);
                total++;
                ret += i;
            }                
        }
        
        // at this point, base = ret
        
        
        int maxCount = 0;   // get majority key
        for(Map.Entry<Integer, Integer> en : count.entrySet()){
            maxCount = Math.max(maxCount, en.getValue());        
        }
        
        int maxVal=0;
        for(Map.Entry<Integer, Integer> en : count.entrySet()){
            if (en.getValue()==maxCount)
                maxVal = en.getKey();
        }
               
        if (maxCount <= total-maxCount) //有沒有過半 沒有的話可以內部解決
            return ret;

        int extra = maxCount - (total - maxCount); //若有extra的話 需要藉助外部element
        for (int i=0; i<n; i++)
        {
            if (extra==0) break;
            if (nums1[i]==nums2[i]) continue;
            if (nums1[i]==maxVal || nums2[i]==maxVal) continue;            
            extra--;
            ret += i;
        }

        if (extra==0) // 都消耗完了
            return ret;
        else
            return -1; // 消耗不完
    }
}