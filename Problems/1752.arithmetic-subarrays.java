// https://leetcode.com/problems/arithmetic-subarrays

class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int n = nums.length;
        int m = l.length;

        List<Boolean> res = new ArrayList<>();
        for(int i=0; i<m; i++){
            int left = l[i];
            int right = r[i];
            res.add(isArithMetic(nums, left, right));

        }

        return res;

    }

    private boolean isArithMetic(int[] nums, int l, int r){

        if(l==r)
            return true;

        List<Integer> list = new ArrayList<>();

        for(int i=l; i<=r; i++){
            list.add(nums[i]);
        }

        Collections.sort(list);

        int gap = list.get(1)-list.get(0);
        for(int i=0; i<list.size()-1; i++){
            if(list.get(i+1)-list.get(i)!=gap)
                return false;
        }

        return true;
    }
}