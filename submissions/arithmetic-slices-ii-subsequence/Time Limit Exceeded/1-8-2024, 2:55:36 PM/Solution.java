// https://leetcode.com/problems/arithmetic-slices-ii-subsequence

class Solution {
    int cnt = 0;
    public int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;

        // boolean[] seen = new boolean[len];
        HashSet<Long> seen = new HashSet<>();
        List<List<Long>> res = new ArrayList<>();
        helper(nums, 0, seen, new ArrayList<>());

        return cnt;
    }

    private void helper(int[] nums, int st, HashSet<Long> seen, List<Long> list){

        if(list.size()>=3){
           cnt++;
        }

        for(int i=st; i<nums.length; i++){

            if(!seen.contains(i)){
             

                if(list.isEmpty() || list.size()==1 || (nums[i]-list.get(list.size()-1)== list.get(list.size()-1)- list.get(list.size()-2))){
                    seen.add((long)i);
                    // seen[i]=true;
                    list.add((long)nums[i]);
                    helper(nums, i+1, seen, list);
                    list.remove(list.size()-1);
                    // seen[i]=false;
                    seen.remove(i);
                }
                
            }
        }

    }
}