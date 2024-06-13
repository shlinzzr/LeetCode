// https://leetcode.com/problems/permutation-in-string

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        List<String> list1 = new ArrayList<>();
        for(char ss : s1.toCharArray()){
            list1.add(String.valueOf(ss));
        }
        
        char[] chArr = s2.toCharArray();
        
        //  for(char cc : chArr){
        //     System.out.println(cc);
        // }
        for(int c=0; c<chArr.length-s1.length(); c++){
            
            
           System.out.println("Entry :0 c="+c +  " chArr="+chArr[c]);
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
                    
                     for(String cc : copy){
                        System.out.println(cc);
                    }
                    System.out.println();
                    
                       System.out.println(chArr[i+c]);   System.out.println();
                    // copy.remove("b");
                    copy.remove(String.valueOf(chArr[i+c]));
                }
                
                if(res) 
                    return true;
            }
            
            
        }
        
        return false;
        
    }
}