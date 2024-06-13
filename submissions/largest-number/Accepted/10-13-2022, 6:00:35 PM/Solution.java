// https://leetcode.com/problems/largest-number

class Solution {
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for(int i=0; i<nums.length; i++){
            arr[i] = String.valueOf(nums[i]);
        }
        
        // System.out.println("500".charAt(100));
        Arrays.sort(arr, new MyComparator());
        
       
        if (arr[0].equals("0")) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for(String s:arr){
            sb.append(s);
        }
        
        return sb.toString();
        
    }
    
    
    class MyComparator implements Comparator<String>{
        @Override
        public int compare(String a, String b){
            
           String order1 = a + b;
           String order2 = b + a;
           return order2.compareTo(order1);
            
            
//             if(a.length()==b.length())
//                 return b.compareTo(a);
            
//             int min = Math.min(a.length(), b.length());
//             int max = Math.max(a.length(), b.length());
//             int i=0;
            
//             for(i=0; i<min; i++){
                
//                 if(a.charAt(i)==b.charAt(i))
//                     continue;
//                 return b.charAt(i)-a.charAt(i);
//             }
//             i--;
            
//             for(; i<max; i++){
//                 if(a.length()>min){
//                     if(a.charAt(i)-'0'>0){
//                          System.out.println("ttttt a");
//                         return b.charAt(i)-a.charAt(i);
//                     }
//                 }else{
//                     if(b.charAt(i)-'0'>0){
//                          System.out.println("ttttt b");
//                         return b.charAt(i)-a.charAt(i);
//                     }
//                 }
                
//             }
//             System.out.println("ttttt");
                                             
//             return Integer.compare(b.length(), a.length());
            
            
        }
    }
}