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


        int max= 0 ;
        for(int i=0; i<len; i++){
            max = Math.max(max, left[i]+right[i]-1);
        }

        return len-max;


    }


    private int ceiling(List<Integer> list, int target){

        int st=0, ed=list.size()-1;

        while(st<ed){
            int mid = st+(ed-st)/2;
            if(target== list.get(mid)){
                return mid;

            }else if(target > list.get(mid)){
                ed = mid;
            }else{
                st = mid+1;
            }
        }

        return st;

    }


}