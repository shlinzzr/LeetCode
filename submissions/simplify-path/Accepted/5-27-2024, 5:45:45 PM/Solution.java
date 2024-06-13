// https://leetcode.com/problems/simplify-path

class Solution {
    public String simplifyPath(String path) {
        
        String[] arr = path.split("/");
        String[] res = new String[arr.length];
        
        int idx =0 ;
        for(int i=0; i<arr.length;i++){
            
            if(arr[i]==null || arr[i].isEmpty() || arr[i].equals(".")){
                //do nothing
            }else if(arr[i].equals("..")){
                if(idx!=0){
                    idx--;
                    res[idx]=null;
                }
            }else{
                res[idx] = arr[i]; 
                idx++;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(String r : res){
            
            if(r==null)
                break;
            sb.append("/").append(r);
        }
        
        if(sb.length()==0)
            sb.append("/");
        
        return sb.toString();
        
    }
}