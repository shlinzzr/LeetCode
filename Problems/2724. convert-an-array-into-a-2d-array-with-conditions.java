// https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions

class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        int len = nums.length;

        int cnt = 0;
        boolean[] seen = new boolean[len];

        while(cnt<len){
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<len ; i++){

                if(!list.contains(nums[i]) && !seen[i]){
                    list.add(nums[i]);
                    seen[i]=true;
                    cnt++;
                }
            }    
            res.add(new ArrayList<>(list));
        }

        return res;

        
        


         
    }
}