// https://leetcode.com/problems/maximum-number-of-balls-in-a-box

class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int max = 0; 
        for(int i=lowLimit; i<=highLimit; i++){
            int d = getDigit(i);
            map.put(d, map.getOrDefault(d, 0)+1);
            
            
            max = Math.max(max, map.get(d));
        }
        return max;
    }
    
    private int getDigit(int n){
        String s = String.valueOf(n);
        int sum = 0;
        for(char c : s.toCharArray()){
            sum+= (c-'0');
        }
        
        return sum;
        
    }
}