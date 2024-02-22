// https://leetcode.com/problems/find-all-duplicates-in-an-array

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int[] arr = new int[100001];
        for(int n : nums){
            arr[n]++;
        }
        
        List<Integer> list = new ArrayList<>();
        
        
        for(int i=0; i<arr.length; i++){
            if(arr[i]>1)
                list.add(i);
        }
        
        return list;
        
    }
}