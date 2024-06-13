// https://leetcode.com/problems/largest-number

class Solution {
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for(int i=0; i<nums.length; i++){
            arr[i] = String.valueOf(nums[i]);
        }
        
        // System.out.println("500".charAt(100));
        Arrays.sort(arr, new MyComparator());
        
        // Arrays.sort(arr, (s1, s2)->s2.compareTo(s1)>0? Integer.compare(s1.length(), s2.length())==0 ? s2.compareTo(s1) : s1.compareTo(s2) :  s2.compareTo(s1) );
        
        StringBuilder sb = new StringBuilder();
        for(String s:arr){
            sb.append(s);
        }
        
        return sb.toString();
        
    }
    
    
    class MyComparator implements Comparator<String>{
        public int compare(String a, String b){
            
            if(a.length()==b.length())
                return b.compareTo(a);
            
            int min = Math.min(a.length(), b.length());
            int max = Math.max(a.length(), b.length());
            int i=0;
            
            for(i=0; i<min; i++){
                
                if(a.charAt(i)==b.charAt(i))
                    continue;
                return b.charAt(i)-a.charAt(i);
            }
            
            for(; i<max; i++){
                
                if(a.length()>min){
                    if(a.charAt(i)>'0')
                        return -1;
                }else{
                    if(b.charAt(i)>'0')
                        return 1;
                }
                
                
                
            }
            
            
            
                                             
            return Integer.compare(a.length(), b.length());
            
            
        }
    }
}