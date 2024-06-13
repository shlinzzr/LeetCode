// https://leetcode.com/problems/maximum-distance-in-arrays

class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int m = arrays.size();
        int res= 0;
        for(List<Integer> list : arrays){
            Collections.sort(list);
        }

        for(int i=0; i<m; i++){
            for(int j=i+1; j<m; j++){
                List<Integer> a = arrays.get(i);
                List<Integer> b = arrays.get(j);

                res = Math.max(res, Math.abs(a.get(a.size()-1)-b.get(0)));
                res = Math.max(res, Math.abs(b.get(b.size()-1)-a.get(0)));
            }
        }

        return res;
    }
}