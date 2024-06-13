// https://leetcode.com/problems/burst-balloons

class Solution {
    int max = 0;
    public int maxCoins(int[] nums) {
        
        List<Integer> list = new ArrayList<>();
        for(int n : nums){
            list.add(n);
        }

        helper(list, 0);

        return max;
    }

    private void helper(List<Integer> list, int curr){
        // System.out.println(list + " curr=" + curr);
        if(list.isEmpty()){
            max = Math.max(max, curr);
            return;
        }

        for(int i=0; i<list.size(); i++){

            int v = list.get(i);
            int prev = i==0 ? 1 : list.get(i-1);
            int next = i==list.size()-1 ? 1 : list.get(i+1);
            int val = prev*v*next;
            list.remove(i);
            helper(list, curr+val);
            list.add(i, v);
        }

    }
}