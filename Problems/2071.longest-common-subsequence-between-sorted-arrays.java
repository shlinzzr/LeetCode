// https://leetcode.com/problems/longest-common-subsequence-between-sorted-arrays

class Solution {
    public List<Integer> longestCommonSubsequence(int[][] arrays) {
        List<Integer> res = new ArrayList<>();

        Set<Integer> set = new LinkedHashSet<>();

        for(int i=0; i<arrays.length; i++){

            Set<Integer> sub = new LinkedHashSet<>();
            for(int j=0; j<arrays[i].length; j++){

                if(i==0) set.add(arrays[i][j]);
                sub.add(arrays[i][j]);
            }

            set.retainAll(sub);
        }

        return new ArrayList<>(set);


    }

    // private List<Integer> lis(int[] arr){

    // }
}