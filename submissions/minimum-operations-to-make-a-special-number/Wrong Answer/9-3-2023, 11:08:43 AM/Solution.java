// https://leetcode.com/problems/minimum-operations-to-make-a-special-number

class Solution {
    public int minimumOperations(String num) {
        int len = num.length();
        
        // 00, 25 ,50, 75
        
        String rev = new StringBuilder(num).reverse().toString();
        
        int min =len;
        // 00, 50
        int firstZero = rev.indexOf("0");
        if(firstZero!=-1){
            // find 5 or 0
            int five = rev.indexOf("5", firstZero+1);
            int zero = rev.indexOf("0", firstZero+1);
            
            // System.out.println(five + " "+ zero +  " " +firstZero );
            
            if(five!=-1){
              return five-1;
            }
            if(zero!=-1)
               return zero-1;
            
            return len-1;
        }
        
        
        int firstFive = rev.indexOf("5");
        if(firstFive!=-1){
            // find 5 or 0
            int two = rev.indexOf("2", firstFive+1);
            int seven = rev.indexOf("7", firstFive+1);
            
               // System.out.println(two + " "+ seven +  " " +firstFive );
           
            if(two!=-1)
               return two-1;
            if(seven!=-1)
                return seven-1;
        }
        
        return len;
        
        
    }
}