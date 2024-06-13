// https://leetcode.com/problems/max-chunks-to-make-sorted-ii

class Solution {
    public int maxChunksToSorted(int[] arr) {
        Set<Integer> lack = new HashSet<>();
        Set<Integer> more = new HashSet<>();

        int[] sorted = new int[arr.length];
        System.arraycopy(arr, 0, sorted, 0, arr.length);
        Arrays.sort(sorted);


        int res = 0;
        for(int i=0; i<arr.length; i++){
            int a = arr[i];
            if(more.contains(a)){
                more.remove(a);
            }else{
                lack.add(a);
            }

            int t = sorted[i];
            if(lack.contains(t)){
                lack.remove(t);
            }else{
                more.add(t);
            }

            if(lack.isEmpty() && more.isEmpty()){
                res++;
            }

        }
        return res;
    }
}