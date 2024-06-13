// https://leetcode.com/problems/largest-number

class Solution {
    public String largestNumber(int[] nums) {
        
        
		// // Comparator to decide which string should come first in concatenation
		// Comparator<String> comp = new Comparator<String>(){
		//     @Override
		//     public int compare(String str1, String str2){
		//         String s1 = str1 + str2;
		// 		String s2 = str2 + str1;
		// 		return s2.compareTo(s1); // reverse order here, so we can do append() later
		//     }
		// };
        
        
        int len = nums.length;
        
        String[] arr = new String[len];
        
        for(int i=0; i<len ; i++){
            arr[i] = String.valueOf(nums[i]);
        }
        
        // Arrays.sort(arr, new Comparator<String>(){
        //    public int compare(String a, String b){
        //        String sa = a+b;
        //        String sb = b+a;
        //        return sb.compareTo(sa);
        //    }
        // });
        
        Arrays.sort(arr,(s1,s2)->(s2+s1).compareTo(s1+s2) );
        
        
        if(arr[0].equals("0"))
            return "0";
        
        StringBuilder res = new StringBuilder();
        for(String s : arr){
            res.append(s);
        }
        
        
        
        
        return res.toString();
    }
    
    
}
