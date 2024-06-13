// https://leetcode.com/problems/hamming-distance

class Solution {
    public int hammingDistance(int x, int y) {
        String s1 = Integer.toBinaryString(x);
        String s2 = Integer.toBinaryString(y);

        s1 = new StringBuilder(s1).reverse().toString();
        s2 = new StringBuilder(s2).reverse().toString();

        // System.out.println(s1 + " " + s2);
        
        int min = Math.min(s1.length(), s2.length());
        
        
        int diff = 0 ;
        for(int i=0; i<min; i++){
            if(s1.charAt(i) != s2.charAt(i))
                diff++;
        }
        
        if(s1.length()>s2.length()){
            for(int i=min; i<s1.length(); i++){
                if(s1.charAt(i)=='1')
                    diff++;
            }
        }else{
            for(int i=min; i<s2.length(); i++){
                if(s2.charAt(i)=='1')
                    diff++;
            }
        }
        
        return diff;
        
    }
}