// https://leetcode.com/problems/find-the-difference-of-two-arrays

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> res = new ArrayList<>();
        
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        
        for(int n1: nums1){
            set1.add(n1);
        }
        
        
        List<Integer> list1 = new ArrayList<>();
        
        for(int n2: nums2){
            
            if(!set1.contains(n2))
                list1.add(n2);
            
            set2.add(n2);
        }
        
         
        List<Integer> list2 = new ArrayList<>();
        
        for(int n1: nums1){
         
            if(!set2.contains(n1)){
                list2.add(n1);
            }
        
        }
        
       
        res.add(list2);
        res.add(list1);
        
        return res;
        
        
        
        
    }
}