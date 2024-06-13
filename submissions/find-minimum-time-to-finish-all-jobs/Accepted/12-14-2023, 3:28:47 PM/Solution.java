// https://leetcode.com/problems/find-minimum-time-to-finish-all-jobs

class Solution {

    long min = Integer.MAX_VALUE;
    public int minimumTimeRequired(int[] jobs, int k) {

        Arrays.sort(jobs);
        List<Integer>[] arr = new ArrayList[k];
        for(int i=0; i<k; i++){
            arr[i] = new ArrayList<>();
        }

        helper(jobs, jobs.length-1, arr, k);
        return (int)min;

    }

    private void helper(int[] jobs, int idx,  List<Integer>[] arr , int k){

        if(idx==-1){
            long sum = getMaxSum(arr);
            min = Math.min(min, sum);
            return;
        }
        
        long sum = getMaxSum(arr);
        if(sum>min) return;

        int flag=0;

        for(int i=0; i<arr.length; i++){
            List<Integer> list = arr[i];
            int total = 0;
            for(int n: list){
                total+=n;
            }
            if(total+jobs[idx]>min) continue;

            if(total==0){
                if(flag==1) continue;
                else flag=1;
            }

            list.add(jobs[idx]);
            helper(jobs, idx-1, arr, k );
            list.remove(list.size()-1);
        }

    }

    private long getMaxSum(List<Integer>[] arr ){
        long max= 0 ;
        for(List<Integer> list : arr){
            long sum = 0;
            for(int n : list)
                sum+=n;

            max = Math.max(max, sum);
        }
        return max;
    }

}