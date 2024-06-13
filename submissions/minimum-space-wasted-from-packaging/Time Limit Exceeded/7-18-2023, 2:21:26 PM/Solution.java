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
            boolean nofit = false;
            for(int p  : packages){
                // System.out.println(p + " " +set.ceiling(p));
                
                if(set.ceiling(p)==null){
                    
                    nofit = true;
                    continue;
                }
                sum += set.ceiling(p)-p;
            }
            
            if(nofit==false)
                min = Math.min(min, sum);
            
            System.out.println(min);
            
        }
        
        return min==Integer.MAX_VALUE? -1 : (int)min;
        
    }
}