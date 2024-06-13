// https://leetcode.com/problems/distribute-elements-into-two-arrays-i

class Solution {
    public int[] resultArray(int[] nums) {
        
        int len = nums.length;
        
        List<Integer> arr1= new ArrayList<>();
        List<Integer> arr2= new ArrayList<>();
        
        arr1.add(nums[0]);
        arr2.add(nums[1]);
        
        for(int i=2; i<len; i++){
            
              if(arr1.get(arr1.size()-1)>arr2.get(arr2.size()-1)){
                  arr1.add(nums[i]);
              } else
                  arr2.add(nums[i]);
        }
        
        int idx=0, i1=0, i2=0;
        
        while(i1<arr1.size()){
            nums[idx++] = arr1.get(i1++);
        }
        
        while(i2<arr2.size()){
            nums[idx++] = arr2.get(i2++);
        }
        
        
        return nums;
    }
}