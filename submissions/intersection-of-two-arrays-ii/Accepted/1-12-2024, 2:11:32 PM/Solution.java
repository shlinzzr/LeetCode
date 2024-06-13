// https://leetcode.com/problems/intersection-of-two-arrays-ii

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        /*
        What if the given array is already sorted? How would you optimize your algorithm?
        
        What if nums1's size is small compared to nums2's size? Which algorithm is better?      

        What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
        
        */
        
        HashMap<Integer, Integer > map = new HashMap<>();
        for(int n : nums1){
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        
        List<Integer> list = new ArrayList<>();
        for(int n : nums2){
            if(map.containsKey(n)){
                list.add(n);
                map.put(n, map.get(n)-1);
                if(map.get(n)==0)
                    map.remove(n);
            }
        }
        
        int[] res = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            res[i] = list.get(i);
        }
        
        return res;
        
        
    }
}