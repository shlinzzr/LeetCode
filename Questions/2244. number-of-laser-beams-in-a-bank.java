// https://leetcode.com/problems/number-of-laser-beams-in-a-bank

// class Solution {
//     public int numberOfBeams(String[] bank) {
        
//         int beams = 0;
        
//         for(int i=0; i<bank.length-1; i++){
            
//             String ststr= bank[i].replaceAll("0", "");
            
//             int stcnt = ststr.length();
            
//             if(stcnt==0)
//                 continue;
            
            
//             boolean hitDev = false;
            
//             for(int j=i+1; j<bank.length; j++){

//                 String edstr= bank[j].replaceAll("0", "");
            
//                 int edcnt = edstr.length();
            
//                 if(edcnt==0){
                    
//                 }else{
                    
//                     beams+=stcnt * edcnt;
//                     break;
//                 }
                    
                
                
                
                
//             }
//         }
        
//         return beams;
        
        
//     }
// }

class Solution {
    public int numberOfBeams(String[] bank) {
        
        int count = 0;
        int lastLasers = 0;
        
        for(String r : bank) {
            
            int lasers = 0;
            
            for(char i : r.toCharArray()) {
                if(i - '0' == 1)
                    lasers++;
            }
            
            count += lastLasers * lasers;
            
            if(lasers > 0)
                lastLasers = lasers;
            
        }
        
        return count;
    }
}