// https://leetcode.com/problems/simplify-path

class Solution {
    public String simplifyPath(String path) {
        
        String[] arr = path.split("/");
        String[] res = new String[arr.length];
        
         // for(int i=0; i<arr.length;i++){
         //    System.out.println(arr[i]);
         // }
        int idx =0 ;
        
        // System.out.println(arr[0]);
           
        
        for(int i=0; i<arr.length;i++){
            
            System.out.println(arr[i]);
           
            
            
            while(arr[i]==null || arr[i].equals(".") || arr[i].isEmpty()){
                i++;
            }
            
            
            if(arr[i].equals("..")){
                if(idx!=0)
                    res[idx--]=null;
            }else{
                
                res[idx++] = arr[i]; 
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(String r : res){
            // System.out.println(r);
            
            if(r==null)
                break;
            sb.append("/").append(r);
        }
        
        if(sb.length()==0)
            sb.append("/");
        
        return sb.toString();
        
        
        
        
//         String test = "/a////b/";
        
//         String[] ar = test.split("/");
//         for(String t: ar)
//         System.out.println(t);
        
//         return "";
        
    }
}