// https://leetcode.com/problems/reverse-integer

// class Solution {
//     public int reverse(int x) {
//       if(x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) return 0;
	
//         char[] chars = ("" + x).toCharArray();
//        String tmps =  "";
         
//         if( '-' == chars[0] && chars.length > 0){
//             tmps = "-";
            
//         }
        
     
//          int n = chars.length;
//          for(int i=0; i<n; i++){
//              if('-' != chars[n-i-1])
//              tmps += chars[n-i-1];
             
             
//             // char tmp = chars[i];
//             // chars[i] = chars[n-i];
//             // chars[n-i] = tmp;
//         }
//         System.out.println(tmps);
        
       
//         int res = 0;
//         if(tmps.length() >0  ) 
//             res = Integer.parseInt(tmps); 
        
//         if(res < Integer.MIN_VALUE || res > Integer.MAX_VALUE )  
//             return 0;
        
//         return res ;
//     }
// }


// My accepted 15 lines of code for Java
class Solution {
public int reverse(int x)
{
    int result = 0;

    while (x != 0)
    {
        int tail = x % 10;
        int newResult = result * 10 + tail;
        if ((newResult - tail) / 10 != result)
        { return 0; }
        result = newResult;
        x = x / 10;
    }

    return result;
}
}