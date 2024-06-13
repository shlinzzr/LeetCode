// https://leetcode.com/problems/strobogrammatic-number

class Solution {
    public boolean isStrobogrammatic(String num) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(0, 0);
        map.put(8, 8);
        
        int len = num.length();
        
        if(len==1 && !map.containsKey(num.charAt(0)-'0')) return false;
            
            
        map.put(6, 9);
        map.put(9, 6);
        for(int i=0; i<len/2; i++){
            int a = num.charAt(i)-'0';
            int b = num.charAt(len-1-i)-'0';
            
            System.out.println(a + " " +  b);
            
            if(!map.containsKey(a) || map.get(a)!=b) return false;
        }
        
        return true;
        
    }
}