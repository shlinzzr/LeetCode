// https://leetcode.com/problems/longest-absolute-file-path

class Solution {
    public int lengthLongestPath(String input) {
        int len = input.length();
        
        // ArrayList<String> files = new ArrayList<>();
        // for (int i=0; i<len; i++){
        //     int i0=i;
        //     while (i<len && input.charAt(i)!='\n')
        //         i++;
        //     files.add(input.substring(i0, i-i0));
        // }
        
        String[] files = input.split("\n");
        
        ArrayList<String> dir = new ArrayList<>();
        int result = 0;
        for (String str : files){
            int k=0;
            while (k<str.length() && str.charAt(k)=='\t')
                k++;
            
            if(k==dir.size()) 
                dir.add(str.substring(k));
            else if(k < dir.size())
                dir.set(k, str.substring(k));
                        
            if (dir.get(k).contains(".")){
                int count = 0;
                for (int i=0; i<=k; i++)
                    count+=dir.get(i).length();
                
                count+=k;
                
                result = Math.max(count,result);
            }
        }
        
        return result;
        
        
        
//         String[] arr = input.split("\n", -1);
//         int max = 0;
//         List<String> list = new ArrayList<>();
//         list.add(arr[0]);
        
//         for(int i =0; i<arr.length; i++){
            
//             String curr = "";
//             String a = arr[i];
            
//             int idx = 0;
//             for(int j=0; j<a.length(); j++){
                
//                 char ch = a.charAt(j);
//                 if(ch=='\t')
//                     curr += list.get(idx++)+ "\n";
//                 else{
//                     if(idx>=list.size())
//                         list.add(a.substring(j));
//                     else 
//                         list.set(idx, a.substring(j));
                    
//                     curr += list.get(idx++);
//                     break;
//                 }
//             }
            
//             if(curr.split("\\.").length>1)
//                 max = Math.max(max, curr.length());
//         }
        
//         return max;
    }
}