// https://leetcode.com/problems/longest-common-prefix

class Solution {
    public String longestCommonPrefix(String[] strs) {
        
            String output ="";
	        
	        
	        
	        String prefix = strs[0];
	        
	        int i = 0;
	        for(char c : prefix.toCharArray()){
	        	
	        	boolean same =true;
	        	 for(String str : strs){
	        		 if(str.length()>i) {
	        			 char ch = str.charAt(i);
		        		 if(ch==c)
		        			 same =true;
		        		 else
		        			 return prefix.substring(0, i);
	        		 }else
	        			 return prefix.substring(0, i);
	        	 }
	        	 
	        	++i;
	        	
	        	output = prefix.substring(0, i);
	        }
	        
	        
	        return output;
}
}