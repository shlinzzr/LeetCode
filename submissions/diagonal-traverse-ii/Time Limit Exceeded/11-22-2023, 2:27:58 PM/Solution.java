// https://leetcode.com/problems/diagonal-traverse-ii

class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int h = nums.size();
        int w= 0 ;
        for(List<Integer> list : nums){
            w =Math.max(w, list.size());
        }
        int n = Math.max(w, h);

        List<Integer> list= new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        // 00, 10,01, 20,11,02, 21,12, 22

        // sum = 0 ~ 2n-2
        int idx = 0;
        for(int sum=0; sum<2*n-1; sum++){

             System.out.println("sum="+sum);
            for(int i=n-1; i>=0; i--){
                int j = sum-i;
                
                if(i>=nums.size() || j>=nums.get(i).size() || i<0 || j<0)
                    continue;
                    // System.out.print(i + "," + j+ "  ");
                
                list.add( nums.get(i).get(j) );
            }
        }

        int[] res = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            res[i] = list.get(i);
        }

    
        return res;
    }
}