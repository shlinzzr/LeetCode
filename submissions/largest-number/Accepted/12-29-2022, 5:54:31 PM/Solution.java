// https://leetcode.com/problems/largest-number

class Solution {
    public String largestNumber(int[] nums) {
        
        int len = nums.length;
        
        String[] arr = new String[len];
        
        for(int i=0; i<len ; i++){
            arr[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(arr, new Comparator<String>(){
           public int compare(String a, String b){
               String sa = a+b;
               String sb = b+a;
               return sb.compareTo(sa);
           }
        });
        
        
        if(arr[0].equals("0"))
            return "0";
        
        StringBuilder res = new StringBuilder();
        for(String s : arr){
            res.append(s);
        }
        
        
        
        
        return res.toString();
    }
}
