// https://leetcode.com/problems/longest-increasing-subsequence

class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;

        List<Integer> list= new ArrayList<>();

        for(int i=0; i<len; i++){

            if(list.isEmpty()){
                list.add(nums[i]);
            }else if(list.get(list.size()-1)<nums[i]){
                list.add(nums[i]);

            }else {
                int idx = binarySearch(list, nums[i]);
                list.set(idx, nums[i]);
            }
        }

        return list.size();
    }


    private int binarySearch(List<Integer> list, int n){

        int st = 0, ed = list.size()-1;


        // 1 3 5, insert 4

        while(st<ed){
            int mid = st + (ed-st)/2;

            if(list.get(mid)<n){
                st = mid+1;
            }else{
                ed = mid;
            }

        }

        return st;
    }
}