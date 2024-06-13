// https://leetcode.com/problems/permutation-in-string

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        List<String> list1 = new ArrayList<>();
        for(char ss : s1.toCharArray()){
            list1.add(String.valueOf(ss));
        }
        
        char[] chArr = s2.toCharArray();
        for(int c=0; c<chArr.length-s1.length()+1; c++){
            
            
            if(list1.contains(String.valueOf(chArr[c]))){
                
                 
                
                List<String> copy = new ArrayList<>();
                 for(char ss : s1.toCharArray()){
                    copy.add(String.valueOf(ss));
                }
               
                
                boolean res = true;
                
                for(int i=0; i<list1.size(); i++){
                    
                
                    if(!copy.contains(String.valueOf(chArr[i+c]))){
                        res = false;
                        break;
                    }
                    
                    copy.remove(String.valueOf(chArr[i+c]));
                }
                
                if(res) 
                    return true;
            }
            
            
        }
        
        return false;
        
    }
}