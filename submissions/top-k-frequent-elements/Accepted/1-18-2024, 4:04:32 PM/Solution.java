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

        for(int u : unique){
            System.out.print(u + ":"+ fmap.get(u)+ " ,");
        }
        System.out.println();

        int n = unique.length;
        quickSelect(unique, 0, n-1, n-k);
        return Arrays.copyOfRange(unique, n - k, n);
    }

    private void quickSelect(int[] nums, int left, int right, int k_smallest){

        if(left>=right) return;

        int pivotIdx = partition(nums, left, right-1, right);
        swap(nums, pivotIdx, right);

        // System.out.println("\nquickselect pivotVal="+pivotVal + " freq="+fmap.get(pivotVal) + " privotIdx="+pivotIdx + " k_smallest="+k_smallest);

        // for(int u : nums){
        //     System.out.print(u + ":"+ fmap.get(u)+ " ,");
        // }
        // System.out.println();
        // swap(nums, pivotIdx, right);

        
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
    /*


    -1:2 ,1:1 ,-3:1 ,2:2 ,3:4 ,5:1 ,7:3 ,-9:1 ,9:2 ,10:3 ,

quickselect pivotVal=4 freq=null privotIdx=9k_smallest=7
-1:2 ,1:1 ,-3:1 ,2:2 ,3:4 ,5:1 ,7:3 ,-9:1 ,9:2 ,10:3 ,

quickselect pivotVal=4 freq=null privotIdx=8k_smallest=7
-1:2 ,1:1 ,-3:1 ,2:2 ,3:4 ,5:1 ,7:3 ,-9:1 ,9:2 ,10:3 ,

quickselect pivotVal=2 freq=2 privotIdx=6k_smallest=7
-1:2 ,1:1 ,-3:1 ,2:2 ,-9:1 ,5:1 ,7:3 ,3:4 ,9:2 ,10:3 ,


*/

    private int partition(int[] nums, int left, int right, int p){ 


         while(left <= right) {

            if(fmap.get(nums[left]) > fmap.get(nums[p])) {
                swap(nums, left, right);
                right--;
            } else {
                left++;
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