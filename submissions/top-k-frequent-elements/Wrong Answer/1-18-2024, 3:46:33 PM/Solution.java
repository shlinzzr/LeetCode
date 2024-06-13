// https://leetcode.com/problems/top-k-frequent-elements

class Solution {

    Map<Integer, Integer> fmap ;
    public int[] topKFrequent(int[] nums, int k) {
        
        fmap = getFreqMap(nums);

        int[] unique = new int[fmap.size()];

        int i=0;
        for(int key: fmap.keySet()){
            unique[i++] = key;
        }

        int n = unique.length;
        quickSelect(unique, 0, n-1, n-k);
        return Arrays.copyOfRange(unique, n - k, n);
    }

    private void quickSelect(int[] nums, int left, int right, int k_smallest){

        if(left>=right) return;


        int pivotVal = fmap.get(nums[left+(right-left)/2]);
        int pivotIdx = partition(nums, left, right-1, pivotVal);
        swap(nums, pivotIdx, right);

        // System.out.println("\n quickselect pivotVal="+pivotVal + " freq="+fmap.get(pivotVal) + " privotIdx="+pivotIdx + "k_smallest="+k_smallest);
        // for(int u : nums){
        //     System.out.print(u + " ,");
        // }
        // System.out.println();

        if(k_smallest==pivotIdx)
            return;
        else if(k_smallest<pivotIdx){ 
            quickSelect(nums, left, pivotIdx-1, k_smallest);
        }else{
            quickSelect(nums, pivotIdx+1, right, k_smallest);
        }
        
        

    }

    private int partition(int[] nums, int left, int right, int p){ 


        //  while(left < right) {

        //     if(fmap.get(nums[left]) > p) {
        //         swap(nums, left, right);
        //         right--;
        //     } else {
        //         left++;
        //     }

        // }
        while(left<right){

            while(fmap.get(nums[left]) < p){
                left++;
            }

            while(fmap.get(nums[right])> p){
                right--;
            }

            if(left<right){
                swap(nums, left, right);
                left++;
                right--;
            }
        }
      

        return left;
    }

    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    } 



    private Map<Integer, Integer> getFreqMap(int[] nums){

        Map<Integer, Integer> fmap = new HashMap<>();
        for(int n : nums){
            fmap.put(n, fmap.getOrDefault(n, 0)+1);
        }
        return fmap;
    }
}