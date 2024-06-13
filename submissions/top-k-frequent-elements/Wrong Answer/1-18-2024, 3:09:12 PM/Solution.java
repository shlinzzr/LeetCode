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
            System.out.print(u + ":" +fmap.get(u) + ", ");
        }
        System.out.println();

        int n = unique.length;
        quickSelect(unique, 0, n-1, n-k); // left=0, right =2-1=1, k=0
        return Arrays.copyOfRange(unique, n - k, n);
    }

    private void quickSelect(int[] nums, int left, int right, int k_smallest){// 0, 1, 0

        if(left>=right) return;

        int pivotVal = nums[left+(right-left)/2]; // pval=1
        int pivotIdx = partition(nums, left, right, pivotVal);//pidx=1

        // System.out.println("\n quickselect pivotVal="+pivotVal + " freq="+fmap.get(pivotVal) + " privotIdx="+pivotIdx + "k_smallest="+k_smallest);
        for(int u : nums){
            System.out.print(u + " ,");
        }
        System.out.println();

        if(k_smallest==pivotIdx)
            return;
        else if(k_smallest<pivotIdx){ //0<1
            quickSelect(nums, left, pivotIdx-1, k_smallest); // 0, 1, 0
        }else{
            quickSelect(nums, pivotIdx+1, right, k_smallest);
        }
        
        

    }

    private int partition(int[] nums, int left, int right, int p){ // 0, 1, p=1
         System.out.println("partition:" + left+ " " + right+ " ,p="+p);
        while(left<right){

            while( fmap.get(nums[left])<fmap.get(p)){
                left++;
            }

            while(fmap.get(nums[right])>fmap.get(p)){
                right--;
            }

            if(left<right){
                swap(nums, left, right);
                left++;
                right--;
            }
        }

        return left; // 1
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