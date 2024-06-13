// https://leetcode.com/problems/find-minimum-time-to-finish-all-jobs

class Solution {

    int min = Integer.MAX_VALUE;
    public int minimumTimeRequired(int[] jobs, int k) {
        List<Integer>[] arr = new ArrayList[k];
        for(int i=0; i<k; i++){
            arr[i] = new ArrayList<>();
        }

        helper(jobs, 0, arr, k);
        return min;

    }

    private void helper(int[] jobs, int idx,  List<Integer>[] arr , int k){

        if(idx==jobs.length){
            int sum = getMaxSum(arr);
            min = Math.min(min, sum);
            return;
        }
        
        int sum = getMaxSum(arr);
        if(sum>min) return;

        for(int i=0; i<arr.length; i++){
            List<Integer> list = arr[i];
            list.add(jobs[idx]);
            helper(jobs, idx+1, arr, k );
            list.remove(list.size()-1);
        }

    }

    private int getMaxSum(List<Integer>[] arr ){
        int max= 0 ;
        for(List<Integer> list : arr){
            int sum = 0;
            for(int n : list)
                sum+=n;

            max = Math.max(max, sum);
        }
        return max;
    }

}