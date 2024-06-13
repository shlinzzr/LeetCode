// https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix

class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        
        int max = 0;
        
        for(int i=0; i<arr1.length; i++){
            for(int j=0; j<arr2.length; j++){
                
                String a = arr1[i]+"";
                String b = arr2[j]+"";
                
                int pre = 0, ai=0, bi=0, cnt=0;
                
                while(ai<a.length() && bi<b.length()){
                    
                    if(a.charAt(ai)!=b.charAt(bi)) break;
                    
                    cnt++;
                    bi++;
                    ai++;
                }
                
                max = Math.max(max, cnt);
                
            }
        }
        
        return max;
        
    }
}