// https://leetcode.com/problems/form-smallest-number-from-two-digit-arrays

class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int n1 : nums1){
            set.add(n1);
        }
        
        for(int n2: nums2){
            if(set.contains(n2))
                return n2;
        }
        
        return nums1[0]*10 +nums2[0] < nums2[0]*10 +nums1[0] ? nums1[0]*10 +nums2[0] : nums2[0]*10 +nums1[0];
        
    }
}