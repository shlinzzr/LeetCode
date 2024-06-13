// https://leetcode.com/problems/number-of-squareful-arrays

class Solution {
    public int numSquarefulPerms(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        Set<List<Integer>> list = new HashSet<>();
        helper(nums, list, new ArrayList<>(), new boolean[len]);
        return list.size();
    }

    private void helper(int[] nums, Set<List<Integer>> list, List<Integer> curr, boolean[] seen){
        if(curr.size()==nums.length){
            list.add(new ArrayList<>(curr));
            return;
        }

        for(int i=0; i<nums.length; i++){

            //剪枝
            if(seen[i] || (i>0) && nums[i]==nums[i-1] && !seen[i-1])
                continue;

            if(seen[i]==false && (curr.isEmpty() || isSquare( curr.get(curr.size()-1)+nums[i]))){
                seen[i]=true;
                curr.add(nums[i]);
                helper(nums, list, curr, seen);
                curr.remove(curr.size()-1);
                seen[i]=false;
            }
        }
    }


    private boolean isSquare(long n){
        return Math.sqrt(n)*Math.sqrt(n)==n;
    }
}