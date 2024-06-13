// https://leetcode.com/problems/mean-of-array-after-removing-some-elements

class Solution {
    public double trimMean(int[] arr) {
        
        int len = arr.length;
        
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>();
        
        int offset = len/20;
        
        Double sum = 0.0;
        int cnt=0 ;
        for(int i=offset; i<len-offset; i++){
            sum += Double.valueOf(arr[i]);
            cnt++;
        }
        
        return sum/cnt;
        
        
    }
}