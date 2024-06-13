// https://leetcode.com/problems/longest-absolute-file-path

class Solution {
    public int lengthLongestPath(String input) {
        int len = input.length();
        
        
        
        
        String[] arr = input.split("\n", -1);
        for(String a : arr){
            System.out.println(a);
        }
        
        
        int max = 0;
        
        
        List<String> list = new ArrayList<>();
        list.add(arr[0]);
        
        
        for(int i =0; i<arr.length; i++){
            
            String curr = "";
            
            String a = arr[i];
            
            int idx = 0;
            for(int j=0; j<a.length(); j++){
                
                char ch = a.charAt(j);
                if(ch=='\t')
                    curr += list.get(idx++)+ "\n";
                else{
                    if(idx>=list.size())
                        list.add(a.substring(j));
                    else 
                        list.set(idx, a.substring(j));
                    curr += list.get(idx++);
                    break;
                }
                
                
                
                // System.out.println("j="+j + " ch="+ch + " curr=" + curr + " list="+list);
                
            }
            
//             System.out.println(i + " ,curr="+curr + " ,a="+a + " ,list=" +  list.toString() + " (curr.split(\".\").length>0)="+(curr.split("\\.").length>1));
            
//             System.out.println(Arrays.asList(curr.split("\\.")));
            
            if(curr.split("\\.").length>1)
                max = Math.max(max, curr.length());
        }
        
        
        return max;
    }
}