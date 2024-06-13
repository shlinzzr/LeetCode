// https://leetcode.com/problems/permutation-in-string

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        List<Character> list1 = new ArrayList<>();
        for(char ss : s1.toCharArray()){
            list1.add((Character)ss);
        }
        
        char[] chArr = s2.toCharArray();
        
        //  for(char cc : chArr){
        //     System.out.println(cc);
        // }
        for(int c=0; c<chArr.length; c++){

            if(list1.contains(chArr[c])){
                
                List<Character> copy = new ArrayList<>(list1);
                
               
                
                boolean res = true;
                
                for(int i=0; i<list1.size(); i++){
                    
                
                    
                    
                    if(!copy.contains(chArr[i+c])){
                        res = false;
                        break;
                    }
                    
                     for(Character cc : copy){
                        System.out.println(cc);
                    }
                    System.out.println();
                    
                       System.out.println(chArr[i+c]);
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