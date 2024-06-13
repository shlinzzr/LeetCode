// https://leetcode.com/problems/largest-number

class Solution {
    public String largestNumber(int[] nums) {

        List<String> list = new ArrayList<>();
        for(int n : nums){
            list.add(n+"");
        }

        Collections.sort(list, (a,b)-> (b+a).compareTo(a+b));
 
        if("0".equals(list.get(0))) return "0";

        StringBuilder sb = new StringBuilder();
        for(String a : list){
            sb.append(a);   
        }

        return sb.toString();
        
    }
}