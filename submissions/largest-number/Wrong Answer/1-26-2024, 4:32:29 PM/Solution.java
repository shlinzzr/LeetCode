// https://leetcode.com/problems/largest-number

class Solution {
    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for(int n : nums){
            list.add(""+n);
        }
        
        Collections.sort(list, (a,b)-> Long.valueOf(b+a).compareTo(Long.valueOf(a+b)));
        
        
        String res = "";
        for(String s : list){
            res+=s;
        }
        
        return res;
        
        
    }
}