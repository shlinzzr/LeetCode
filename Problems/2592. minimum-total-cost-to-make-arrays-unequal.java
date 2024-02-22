// https://leetcode.com/problems/minimum-total-cost-to-make-arrays-unequal

class Solution {
    public long minimumTotalCost(int[] nums1, int[] nums2) {
        //https://www.youtube.com/watch?v=WGcjEzidnEA
        
        long ans=0;
        int count=0;
        Map<Integer,Integer> map=new HashMap();
        for(int i=0;i<nums1.length;i++)
        {
            if(nums1[i]==nums2[i])
            {
                ans+=i;
                map.put(nums1[i], map.getOrDefault(nums1[i],0)+1);
                count++;
            }               
        }
        int max=0;
        int maxcount=0;
        for(Map.Entry<Integer,Integer> ent:map.entrySet())
        {
            if(ent.getValue()>maxcount)
            {
                maxcount=ent.getValue();
                max=ent.getKey();
            }
        }
        int swap=2*maxcount-count;
        for(int i=0;swap>0 && i<nums1.length;i++)
        {
            if(nums1[i]!=nums2[i]&& nums1[i]!=max&&nums2[i]!=max)
            {
                ans+=i;
                swap--;
            }
        }
        return swap>0?-1:ans;
    }
}