// https://leetcode.com/problems/minimum-space-wasted-from-packaging

class Solution {
    public int minWastedSpace(int[] packages, int[][] boxes) {
        int len = packages.length;
        
        int bLen = boxes.length;
        
        long min = Integer.MAX_VALUE;
        
        for(int[] arr : boxes){
            
            TreeSet<Integer> set = new TreeSet<>();
            for(int a : arr){
                set.add(a);
            }
            
            long sum = 0;
            
            for(int p  : packages){
                // System.out.println(p + " " +set.ceiling(p));
                sum += set.ceiling(p)-p;
            }
            
            min = Math.min(min, sum);
            
             System.out.println(min);
            
        }
        
        return (int)min;
        
    }
}