// https://leetcode.com/problems/max-chunks-to-make-sorted-ii

class Solution {
    public int maxChunksToSorted(int[] arr) {
        Map<Integer,Integer> lack = new HashMap<>();
        Map<Integer,Integer> more = new HashMap<>();

        int[] sorted = new int[arr.length];
        System.arraycopy(arr, 0, sorted, 0, arr.length);
        Arrays.sort(sorted);


        int res = 0;
        for(int i=0; i<arr.length; i++){
            int a = arr[i];
            if(more.containsKey(a)){
                more.put(a, more.get(a)-1);
                if(more.get(a)==0)
                    more.remove(a);

            }else{
                lack.put(a, lack.getOrDefault(a,0)+1);
            }

            int t = sorted[i];
            if(lack.containsKey(t)){
                lack.put(t, lack.get(t)-1);
                if(lack.get(t)==0)
                    lack.remove(t);

            }else{
                more.put(t, more.getOrDefault(t, 0)+1);
            }

            if(lack.isEmpty() && more.isEmpty()){
                res++;
            }

        }
        return res;
    }
}