// https://leetcode.com/problems/minimum-incompatibility

class Solution {

    int min = Integer.MAX_VALUE;
    public int minimumIncompatibility(int[] nums, int k) {

        Arrays.sort(nums);
        int len = nums.length;
        TreeSet<Integer>[] arr = new TreeSet[k];
        for(int i=0; i<k; i++){
            arr[i] = new TreeSet<>();
        }

        if(len%k!=0) return -1;

        int siz = len/k;

        helper(nums, 0, arr, siz);

        return min==Integer.MAX_VALUE? -1 : min;
    }

    private void helper(int[] nums, int st, TreeSet<Integer>[] arr, int siz){

        // if(st==nums.length){
        //     int sum = 0 ;
        //     for(int i=0; i<arr.length; i++){
        //         sum+=arr[i].last()-arr[i].first();
        //     }
        //     min = Math.min(min, sum);
        //     return;
        // }
        
        // [6,3,8,1,3,1,2,2]
        //  1 1 2 2 3 3 6 8 
        // greedy : error
        // 1 2 1 2 3 6 3 8

        for(int i=st; i<nums.length; i++){
            boolean find =false;
            for(Set<Integer> set : arr){
                if(!set.contains(nums[i]) && set.size()<siz){
                    find = true;
                    set.add(nums[i]);
                    break;
                }
            }
            System.out.println(i + " f="+find);
            

            if(find==false){
                min = -1;
                return;
            }
        }

         int sum = 0 ;
            for(int i=0; i<arr.length; i++){
                System.out.println(i + " set="+arr[i]);
                if(arr[i].size()>0)
                sum+=arr[i].last()-arr[i].first();
            }
            min = Math.min(min, sum);

    }
}