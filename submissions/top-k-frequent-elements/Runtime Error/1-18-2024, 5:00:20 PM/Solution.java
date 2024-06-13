// https://leetcode.com/problems/top-k-frequent-elements

class Solution {
     
    Map<Integer, Integer> map;
    public int[] topKFrequent(int[] nums, int k) {
        
        // 1. hashmap + pq
        // 2. quickselect
        
        map = new HashMap<>();
        for(int n: nums){
            map.put(n , map.getOrDefault(n,0)+1);
        }
        
        int len = map.size();
        int[] unique = new int[len];
        int i=0;
        for(int num : map.keySet()){
            unique[i++] = num;
        }
        
        
        quickselect(unique, 0, len-1, k);
        
        return Arrays.copyOfRange(unique, len-k, len);
    }
    
    private void quickselect(int[] nums, int left, int right, int k){
        
        if(left>=right) return;
        
        int pivotIdx = partition(nums, left, right-1, right);
        swap(nums, pivotIdx, right);
        
        if(pivotIdx==k) return;
        else if(pivotIdx<k){
            quickselect(nums, left, pivotIdx, k);
        }else {
            quickselect(nums, pivotIdx+1, right, k);
        }
            
    }
    
    private int partition(int[] nums, int left, int right, int pivot){
        while(left<=right){
            if(map.get(nums[left])>map.get(nums[pivot])){
                swap(nums, left, right);
                right--;
            }else
                left++;
        }
        return left;
    }
    
    private void swap(int[] nums, int a, int b){
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}