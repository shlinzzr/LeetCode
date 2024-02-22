// https://leetcode.com/problems/minimum-number-of-removals-to-make-mountain-array

class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int len = nums.length;

        int[] left = new int[len];
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<len; i++){
            if(list.isEmpty() || nums[i]>list.get(list.size()-1)){
                list.add(nums[i]);
            }else{
                int idx = ceiling(list, nums[i]);
                list.set(idx, nums[i]);
            }

            left[i] = list.size();
        }

        int[] right = new int[len];
        list = new ArrayList<>();
        for(int i=len-1; i>=0; i--){
            if(list.isEmpty() || nums[i]>list.get(list.size()-1)){
                list.add(nums[i]);
            }else{
                int idx = ceiling(list, nums[i]);
                list.set(idx, nums[i]);
            }
            right[i] = list.size();
        }

        // for(int i=0; i<len; i++){
        //     System.out.print(left[i] + ",");
        // }
        // System.out.println();

        // for(int i=0; i<len; i++){
        //     System.out.print(right[i] + ",");
        // }
        // System.out.println();


        int max= 0 ;
        for(int i=1; i<len-1; i++){
            if(left[i]>1 && right[i]>1){
                max = Math.max(max, left[i] + right[i] -1);
            }
            // max = Math.max(max, (left[i]>1? left[i] : 0) + (right[i]>1?right[i] : 0)-1);
        }

        return len-max;


    }


    private int ceiling(List<Integer> list, int num){

        int st=0, ed=list.size()-1;

        while(st<ed){
            int mid = st+(ed-st)/2;
            if(num == list.get(mid)){
                return mid;

            }else if(list.get(mid) > num){
                ed = mid;
            }else{
                st = mid+1;
            }
        }

        return st;

    }


}