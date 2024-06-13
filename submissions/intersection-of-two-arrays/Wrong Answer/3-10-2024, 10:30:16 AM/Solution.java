// https://leetcode.com/problems/intersection-of-two-arrays

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();

        for(int n : nums1){
            set.add(n);
        }

        List<Integer> list = new ArrayList<>();

        for(int n : nums2){
            if(set.contains(n))
                list.add(n);
        }

        int[] res = new int[list.size()];

        for(int i=0; i<list.size(); i++){
            res[i] = list.get(i);
        }

        return res;

    }
}