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

    private void  helper(int[] nums, int st, TreeSet<Integer>[] arr, int siz){

        if(st==nums.length){
            int sum = getSum(arr);
            min = Math.min(min, sum);
            return;
        }
        
        // [6,3,8,1,3,1,2,2]
        //  1 1 2 2 3 3 6 8 
        // greedy : error
        // 1 2 1 2 3 6 3 8
        Set<Set<Integer>> visited = new HashSet<>();
        

        boolean find =false;

        if(getSum(arr)>min) 
            return ;
            
        for(Set<Integer> set : arr){

            if(visited.contains(set)) continue;

            if(!set.contains(nums[st]) && set.size()<siz){
                find = true;
                set.add(nums[st]);
          
                // if( helper(nums, i+1, arr, siz) )
                //     return true;
                helper(nums, st+1, arr, siz) ;
                set.remove(nums[st]);
                 visited.add(set);
            }
        }



        //  int sum = 0 ;
        //     for(int i=0; i<arr.length; i++){
        //         System.out.println(i + " set="+arr[i]);
        //         if(arr[i].size()>0)
        //         sum+=arr[i].last()-arr[i].first();
        //     }
        //     min = Math.min(min, sum);

    }


    private int getSum( TreeSet<Integer>[] arr){
        int sum = 0 ;
        for(int i=0; i<arr.length; i++){
                //  System.out.println("st="+st +  " set[" + i + "]="+arr[i]);
            if(arr[i].size()>0)
                sum+=arr[i].last()-arr[i].first();
        }
        return sum;
    }
}