// https://leetcode.com/problems/find-the-longest-balanced-substring-of-a-binary-string

class Solution {
    public int findTheLongestBalancedSubstring(String s) {
        
        HashMap<Integer, Integer> map = new HashMap<>(); //val, idx
        map.put(0, -1);
        int sum=0;
        int max=0;
        Integer prev = null;
        for(int i=0; i<s.length(); i++){
            
            if(prev!=null && prev==1 && s.charAt(i)=='0')
                map.put(0, i);
            
            
            sum += (s.charAt(i)=='0')? -1:1;
            
            if(map.containsKey(sum)){
                max = Math.max(max, i-map.get(sum));
            }else{
                map.put(sum, i);
            }
            // System.out.println(sum);
            
            
            
            prev= s.charAt(i)-'0';
            
        }
        return max;
        
        
    }
}