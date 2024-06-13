// https://leetcode.com/problems/divide-array-into-arrays-with-max-difference

class Solution {
    public int[][] divideArray(int[] nums, int k) {

        if(nums.length==0)return new int[][];
        
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        res.get(0).add(nums[0])

        if(nums.length==1) return new int[][]{{res.get(0).get(0)}};

        for(int i=1; i<nums.length-1; i++){
            if(nums[i]-res.get(res.size()-1).get(0)<=k){
                res.get(res.size()-1).add(nums[i])
            }else{
                res.add(new ArrayList<>());
                res.get(res.size()-1).add(nums[i]);
            }
        }


        int[][] rt = new int[res.size()][];

        for(int i=0;i<res.size(); i++){}
        
    
    }
}